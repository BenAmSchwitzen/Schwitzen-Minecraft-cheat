package schwitzen.events.com.darkmagician6.eventapi;



import java.lang.annotation.*;

/**
 * Marks a method so that the EventManager knows that it should be registered.
 * The priority of the method is also set with this.
 *
 * @author DarkMagician6
 * @see com.darkmagician6.eventapi.types.Priority
 * @since July 30, 2013
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTarget {

    byte value() default schwitzen.events.com.darkmagician6.eventapi.types.Priority.MEDIUM;
}
