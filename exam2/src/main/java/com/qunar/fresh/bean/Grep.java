package com.qunar.fresh.bean;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.qunar.fresh.SubCommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liyingsong on 16-5-30.
 */
public class Grep extends LinuxCommand {
    private static Logger logger = LoggerFactory.getLogger(Grep.class);

    Map<Pattern, SubCommandHandler<String, List<String>, List<String>>> grepMap = Maps.newHashMap();

    {
        grepMap.put(Pattern.compile("(grep) (\\S+) (\\S+)$"), new SubCommandHandler<String, List<String>, List<String>>() {
            @Override
            public List<String> handleCommand(String command, List<String> strings) {
                commandSegment = Splitter.on(' ').splitToList(command);
                commandPattern = commandSegment.get(1);
                fileName = commandSegment.get(2);
                File file = new File(fileName);
                if (Files.isFile().apply(file)) {
                    try {
                        Files.readLines(file, Charsets.UTF_8, new LineProcessor() {
                            @Override
                            public boolean processLine(String line) throws IOException {
                                if (line.indexOf(commandPattern) != -1) {
                                    result.add(line);
                                }
                                return true;
                            }

                            @Override
                            public Object getResult() {
                                logger.info(Joiner.on("\n").join(result));
                                return result;
                            }
                        });
                    } catch (IOException e) {
                        logger.error(e.toString());
                    }
                }

                return null;
            }
        });
        grepMap.put(Pattern.compile("(grep) (\\S+)$"), new SubCommandHandler<String, List<String>, List<String>>() {
            @Override
            public List<String> handleCommand(String command, List<String> tempResult) {
                commandSegment = Splitter.on(' ').splitToList(command);
                commandPattern = commandSegment.get(1);
                for (String line : tempResult) {
                    if (line.indexOf(commandPattern) != -1) {
                        logger.info(Joiner.on("\n").join(result));
                        result.add(line);
                    }
                }
                return result;
            }
        });
    }

    @Override
    public boolean judgeCommand(final String command) {
        return FluentIterable.from(grepMap.keySet()).anyMatch(new Predicate<Pattern>() {
            @Override
            public boolean apply(Pattern input) {
                return input.matcher(command).find();
            }
        });
    }

    @Override
    public List<String> handle(String command, List<String> tempResult) {
        for (Map.Entry<Pattern, SubCommandHandler<String, List<String>, List<String>>> entry : grepMap.entrySet()) {
            if (entry.getKey().matcher(command).find()) {
                return entry.getValue().handleCommand(command, tempResult);
            }
        }
        return null;
    }


}
