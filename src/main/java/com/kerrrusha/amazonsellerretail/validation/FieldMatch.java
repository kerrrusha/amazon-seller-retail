package com.kerrrusha.amazonsellerretail.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface FieldMatch {
    String message() default "Fields must match";

    String first();

    String second();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
