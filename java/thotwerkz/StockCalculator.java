import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Investment {
    public int buyPrice;
    public int units;

    public Investment (int buyPrice, int units) {
        this.buyPrice = buyPrice;
        this.units = units;
    }
}
public class StockCalculator {
    /*
    * using a hardocoded map of current investments per stock
    * */
    private static Map<String, Investment> currentHoldings = new HashMap<String, Investment>() {
        {
            put("JP", new Investment(400,3));
            put("MG", new Investment(300,1));
            put("TM", new Investment(200,5));
            put("A2B", new Investment(100,10));
        }

    };

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int margin =0;
            while (true) {
                String line = sc.nextLine();
                if (line.equals("") || line.equals("EOF")) {
                    break;
                }
                String[] input = line.split(" ");
                margin += getStockMargin(input[0], Integer.parseInt(input[1]));

            }
            System.out.println(((margin>0)? "Profit" : (margin<0)?"Loss" :"No Profit No Loss") + " " + Math.abs(margin));

        } catch(Exception ex) {
            System.out.println(" err : "+ex.getMessage());
            throw ex;
        }
    }

    private static int getStockMargin(String stockName, int currentPrice) {
        Investment currentStockInvestment = currentHoldings.get(stockName);
        return (currentPrice - currentStockInvestment.buyPrice) * currentStockInvestment.units;
    }
}
