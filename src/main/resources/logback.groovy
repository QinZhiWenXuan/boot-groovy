import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter

import static ch.qos.logback.classic.Level.*

appender("consoleAppender", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = ".%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg %n"
    }
    filter(ThresholdFilter) {
        level = TRACE
    }
}
appender("dailyRollingFileAppender", RollingFileAppender) {
    file = "E:/log/boot-groovy/app.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "rest-demo.%d{yyyy-MM-dd}.log"
        maxHistory = 30
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg %n"
    }
}

def appenderNames = ["consoleAppender", "dailyRollingFileAppender"]

logger("org.springframework", INFO ,appenderNames)
root(DEBUG, appenderNames)