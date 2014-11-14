import java.time.ZonedDateTime;

/**
 * Created by 예규 on 2014-05-11.
 */
public interface AbstractZoneTimeClient extends TimeClient {
    public ZonedDateTime getZonedDateTime(String zoneString);
}
