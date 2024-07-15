# Soda Machine Project

## Description
This project simulates a vending machine system that accepts paper money, allows product orders, and implements promotions based on the quantity of products purchased. The machine performs the following functions:
1. Accepts specified denominations.
2. Orders products.
3. Processes payments and returns change if any.
4. Applies promotions if three or more of the same product are purchased.
5. Displays the total quantity of products received after applying promotions.

## Project Structure

- `model`: Contains classes for storing product information and money denominations.
    - `Product.java`: Class representing a product.
    - `Note.java`: Class representing a money denomination.
    - `ListProduct.java`: Class containing the list of available products.
    - `ListNote.java`: Class containing the list of accepted money denominations.

- `service`: Contains service classes to handle the various functions of the vending machine.
    - `MoneyService.java`: Handles the acceptance of money denominations.
    - `OrderService.java`: Handles product ordering.
    - `PaymentService.java`: Handles payment processing and returning change.
    - `PromotionService.java`: Handles promotions based on the quantity of products purchased.

- `Main`: Contains the class that integrates the services into a complete process.
    

## Usage

### System Requirements
- Java JDK 8 or higher

### Installation and Running the Application

1. Clone the repository to your machine:
   ```bash
   git clone https://github.com/thiendsu2303/Soda-Machine.git
   cd src
2. Compile the Java files:
   ```bash
   javac -d bin src/model/*.java src/service/*.java src/*.java
3. Run the application:
   ```bash
   java -cp bin Main
   
- Or you can run by click the button on IDE.
4. Follow on-screen instruction to input money, order products and process payment.

### Detailed Instructions
1. Input Money:
 - Run the application and enter the denominations you want to insert (10000, 20000, 50000, 100000, 200000 VND).
 - Enter 0 to finish inserting money and proceed to the next step.
2. Order Products:
 - Enter the name of the product you want to buy (Coke, Pepsi, Soda).
 - Enter the quantity of the product you want to buy.
 - Enter done to finish ordering and proceed to payment.
3. Payment:
 - The application will display the total amount due and ask if you want to proceed with the payment (yes/no).
 - If you choose yes, the application will display the change to be returned and check for promotions.
 - If you choose no, the application will refund the inserted money.
4. Promotion:
 - If you buy three or more of the same product, you have a chance to receive an additional free product.
 - The application will display the total quantity of products received after applying promotions.
5. Completion:
 - The application will display a final message showing the total quantity of products received.
 - End of the process.

## Author
This project was develop by Mai Chien Vi Thien :>