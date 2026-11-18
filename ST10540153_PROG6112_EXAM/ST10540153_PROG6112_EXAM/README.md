# PROG6112 2026 Practice Paper (Mattress Sales) – Worked Solution

Two NetBeans "Java with Maven" projects:

| Folder    | Question                          | Main class                                  |
|-----------|-----------------------------------|---------------------------------------------|
| Question1 | Product sales report (arrays)      | `com.mycompany.question1.ProductSalesReport` |
| Question2 | Product App GUI (VAT + commission) | `com.mycompany.question2.ProductApp`         |

## Opening in NetBeans
1. File > Open Project, then select the `Question1` (or `Question2`) folder. NetBeans recognises it from `pom.xml`.
2. Run: press F6 (Run Project), or right-click the main class > Run File.
   Question 1 asks for the sales in the Output window: type each number and press Enter.
3. Tests: right-click the project > Test (Alt+F6). The tests are under **Test Packages**.
   The first build needs internet so Maven can download JUnit 5.

## Files
Question1
- `IProduct.java` – interface from Q.1.2
- `Product.java` – GetTotalProductsSold, GetAverageProductSold, GetMostPopularProduct
- `PrintProduct.java` – prints the total, average and most popular product (Q.1.3)
- `ProductSalesReport.java` – captures the sales into the 2D array and runs the report
- Test Packages: `ProductTest.java` – the 2 unit tests from Q.1.4

Question2
- `IProductCalculations.java` – interface from Q.2.5
- `ProductCalculations.java` – GetVat (15%), GetCommission (5%), GetTotal
- `ProductApp.java` – the GUI (text boxes, combo box, PROCESS button, menus); saves data.txt
- Test Packages: `ProductCalculationsTest.java` – the required GetVat test plus 2 extra tests

`data.txt` is created in the Question2 project folder each time a sale is processed.

The projects target Java 17. If your JDK is older, change `maven.compiler.release` in `pom.xml`.
