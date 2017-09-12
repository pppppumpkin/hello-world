package com.qunar.fresh.bean;

import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
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
public class Wc extends LinuxCommand {
    private static Logger logger = LoggerFactory.getLogger(Wc.class);

    private int lineCounter;

    Map<Pattern, SubCommandHandler<String, List<String>, List<String>>> wcMap = Maps.newHashMap();
    Pattern pattern1 = Pattern.compile("(wc) (-l) (\\S+)");
    Pattern pattern2 = Pattern.compile("(wc) (-l)");

    {
        wcMap.put(pattern1, new SubCommandHandler<String, List<String>, List<String>>() {
            @Override
            public List<String> handleCommand(String command, List<String> tempResult) {
                Matcher matcher = pattern1.matcher(command);
                fileName = matcher.group(2);
                try {
                    lineCounter = Files.readLines(new File(fileName), Charsets.UTF_8).size();
                } catch (IOException e) {
                    logger.error(e.toString());
                }
                result.add(lineCounter + "");
                return result;
            }
        });
        wcMap.put(pattern2, new SubCommandHandler<String, List<String>, List<String>>() {
            @Override
            public List<String> handleCommand(String command, List<String> tempResult) {
                lineCounter = tempResult.size();
                result.add(lineCounter + "");
                return result;
            }
        });
    }

    @Override
    public boolean judgeCommand(final String command) {
        return FluentIterable.from(wcMap.keySet()).anyMatch(new Predicate<Pattern>() {
            @Override
            public boolean apply(Pattern input) {
                return input.matcher(command).find();
            }
        });
    }

    @Override
    public List<String> handle(String command, List<String> tempResult) {
        for (Map.Entry<Pattern, SubCommandHandler<String, List<String>, List<String>>> entry : wcMap.entrySet()) {
            if (entry.getKey().matcher(command).find()) {
                return entry.getValue().handleCommand(command, tempResult);
            }
        }
        return null;
    }
}
