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

    public PCR_Test(int testId) {
        this.testId = testId;
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
