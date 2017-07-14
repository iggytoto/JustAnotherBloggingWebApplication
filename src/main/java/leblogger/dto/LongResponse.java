package leblogger.dto;

/**
 * Created by Iggytoto on 14.07.2017.
 */
public class LongResponse {

    private Long value;

    public LongResponse(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public static final LongResponse ERROR_RESPONSE = new LongResponse(-1L);
}
