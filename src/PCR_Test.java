import java.time.LocalDateTime;

public class PCR_Test implements Comparable<PCR_Test> {
    private LocalDateTime testTime;
    private String personId;
    private int testId;
    private int stationId;
    private int districtId;
    private int regionId;
    private boolean testResult;
    private String note;

    public PCR_Test(LocalDateTime testTime, String personId, int testId, int stationId, int districtId, int regionId, boolean testResult, String note) {
        this.testTime = testTime;
        this.personId = personId;
        this.testId = testId;
        this.stationId = stationId;
        this.districtId = districtId;
        this.regionId = regionId;
        this.testResult = testResult;
        this.note = note;
    }

    @Override
    public int compareTo(PCR_Test test) {
        if (this.testId > test.testId) {
            return 1;
        } else if (this.testId < test.testId) {
            return -1;
        } else {
            return 0;
        }
    }
}
