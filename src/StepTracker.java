public class StepTracker {

    public MonthData[] monthToData;
    int Goal = 10_000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
     class MonthData {
        public int[] monthData = new int[30];
    }
    public void saveSteps(int month, int day, int stepAmount) {

        MonthData tempData = new MonthData();
        tempData.monthData[day-1] = stepAmount;
        for (int i = 0; i < tempData.monthData.length; i++){
            if ((day-1)==i){
                monthToData[month].monthData[i] = tempData.monthData[day-1];
                break;
            }
        }
    }
    public void printStatMonth(int month) {
        MonthData tempData = new MonthData();
        for (int i = 0; i < tempData.monthData.length; i++) {
            System.out.println("За " + (i + 1) + " день пройдено: " + monthToData[month].monthData[i] + " шагов");
        }
    }
    public void changeGoal(int goal) {
        System.out.println("Ваша предыдущая цель " + Goal + " шагов");
        Goal = goal;
        System.out.println("Теперь цель составляет " + Goal+ " шагов!");
    }
}

