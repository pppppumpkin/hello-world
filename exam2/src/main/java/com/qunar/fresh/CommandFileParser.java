package com.qunar.fresh;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by liyingsong on 16-5-27.
 */
public class CommandFileParser {
    private static Logger logger = LoggerFactory.getLogger(CommandFileParser.class);
    private static List<String> tempResult = Lists.newArrayList();

//    public static void parseLinuxCommand(File commandFile) throws IOException {
//        Files.readLines(commandFile, Charsets.UTF_8, new LineProcessor<String>() {
//            @Override
//            public boolean processLine(String line) throws IOException {
//                List<String> commands = Splitter.on('|').trimResults().splitToList(line.toLowerCase());
//                for (String command : commands) {
//                    List<String> commandSegment = Splitter.on(' ').omitEmptyStrings()
//                            .trimResults().splitToList(command);
//                    String commandType = commandSegment.get(0);
//                    if (Objects.equal(commandType, "cat")) {
//                        CatLinuxCommand cat = new CatLinuxCommand();
//                        if (commandSegment.size() == 2) {
//                            cat.setFileName(commandSegment.get(1));
//                            tempResult = cat.execute();
//                        } else if (commandSegment.size() == 1) {
//                            cat.setTempResult(tempResult);
//                        }
//                    } else if (Objects.equal(commandType, "grep")) {
//                        GrepLinuxCommand grep = new GrepLinuxCommand();
//                        grep.setCommandParameter(commandSegment.get(1));
//                        if (commandSegment.size() == 3) {
//                            grep.setFileName(commandSegment.get(2));
//                            tempResult = grep.execute();
//                        } else if (commandSegment.size() == 2) {
//                            grep.setTempResult(tempResult);
//                            tempResult = grep.execute(tempResult);
//                        }
//
//                    } else if (Objects.equal(commandType, "wc")) {
//                        WcLinuxCommand wc = new WcLinuxCommand();
//                        wc.setCommandParameter(commandSegment.get(1));
//                        if (commandSegment.size() == 3) {
//                            wc.setFileName(commandSegment.get(2));
//                            tempResult = wc.execute();
//                        } else if (commandSegment.size() == 2) {
//                            wc.setTempResult(tempResult);
//                            tempResult = wc.execute(tempResult);
//                        }
//                    } else {
//                        logger.info("sorry, can not parse command {}\n", commandType);
//                    }
//                }
//                logger.info(Joiner.on('\n').join(tempResult));
//                return true;
//            }
//
//            @Override
//            public String getResult() {
//                return null;
//            }
//        });

//    }

}
