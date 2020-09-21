public class SplitMoney {
    public static void main(String[] args) {
        System.out.println(split(101020200));
    }
    public static String split(long money){
        String moneyStr = "";
        while (money > 0){
            long temp = money/1000;
            long littleMoney = money - temp*1000;
            String littleMoneyStr = String.valueOf(littleMoney);
            int littleMoneyStrLen = littleMoneyStr.length();
            for (int i=0;i<3-littleMoneyStrLen;i++){
                if (temp == 0)
                    break;
                littleMoneyStr = "0"+littleMoneyStr;
            }
            if ("".equals(moneyStr)){
                moneyStr = littleMoneyStr;
            }else {
                moneyStr = littleMoneyStr+","+moneyStr;
            }
            money = temp;
        }
        return moneyStr;
    }
}
