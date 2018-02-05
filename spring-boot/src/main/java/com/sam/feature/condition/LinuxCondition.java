package com.sam.feature.condition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author sam at 2018/1/30 下午3:28
 */
public class LinuxCondition implements Condition {

    Logger logger = LoggerFactory.getLogger(LinuxCondition.class);

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String osName = conditionContext.getEnvironment().getProperty("os.name");
        logger.info("os name is {}", osName);
        return osName.contains("Mac");
    }
}
