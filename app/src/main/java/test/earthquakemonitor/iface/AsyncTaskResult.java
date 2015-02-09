package test.earthquakemonitor.iface;

import test.earthquakemonitor.dto.DtoAllHour;

/**
 * Created by luisangelgarcia on 06/02/15.
 */
public interface AsyncTaskResult {
    public void taskFinish(DtoAllHour dtoAllHour, String json);
}
