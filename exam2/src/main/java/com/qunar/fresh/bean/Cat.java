package com.qunar.fresh.bean;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
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
public class Cat extends LinuxCommand{
    private static Logger logger = LoggerFactory.getLogger(Cat.class);

    Map<Pattern, SubCommandHandler<String, List<String>, List<String>>> catMap = Maps.newHashMap();
    Pattern pattern1 = Pattern.compile("(cat) (\\S+)$");
//    Pattern pattern2 = Pattern.compile("cat");

    {
        catMap.put(pattern1, new SubCommandHandler<String, List<String>, List<String>>() {
            @Override
            public List<String> handleCommand(String command, List<String> tempResult) {
//                commandSegment = Splitter.on(' ').splitToList(command);
//                fileName = commandSegment.get(1);
                Matcher matcher = pattern1.matcher(command);
                fileName = matcher.group(2);
                try {
                    result = Files.readLines(new File(fileName), Charsets.UTF_8);
                } catch (IOException e) {
                    logger.error(e.toString());
                }
                logger.info(Joiner.on("\n").join(result));
                return result;
            }
        });
    }

    @Override
    public boolean judgeCommand(final String command) {
        return FluentIterable.from(catMap.keySet()).anyMatch(new Predicate<Pattern>() {
            @Override
            public boolean apply(Pattern input) {
                return input.matcher(command).find();
            }
        });
    }

    @Override
    public List<String> handle(String command, List<String> tempResult) {
        for (Map.Entry<Pattern, SubCommandHandler<String, List<String>, List<String>>> entry : catMap.entrySet()) {
            if (entry.getKey().matcher(command).find()) {
                return entry.getValue().handleCommand(command, tempResult);
            }
        }
        return null;
    }

}
