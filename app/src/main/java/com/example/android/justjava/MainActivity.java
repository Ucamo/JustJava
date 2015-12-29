package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity=2;
    boolean hasWhippedCream=false;
    boolean hasChocolate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Total = $";
        int price = calculatePrice();
        hasWhippedCream= CheckForWhippedCream();
        hasChocolate=CheckForChocolate();
        displayMessage(createOrderSummary(price));
    }

    public void increment(View view) {
        quantity=quantity+1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        quantity=quantity-1;
        displayQuantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private boolean CheckForWhippedCream()
    {
        CheckBox checkBox = (CheckBox) findViewById(R.id.hasWhippedCream);
        boolean isChecked = checkBox.isChecked();
        return isChecked;
    }

    private boolean CheckForChocolate()
    {
        CheckBox checkBox = (CheckBox) findViewById(R.id.hasChocolate);
        boolean isChecked = checkBox.isChecked();
        return isChecked;
    }

    /*
    * Return a message with all the information of the order
    * @param price is the price of a cup of coffee
    * */
    private String createOrderSummary(int price){
        String message = "Name: Uriel Carrillo \n";
        message+="Add whipped cream? : "+hasWhippedCream+"\n";
        message+="Add chocolate? : "+hasChocolate+"\n";
        message+="Quantity: "+quantity+"\n";
        message+="Total: $"+price+"\n";
        message+="Thank You!";
        return  message;
    }
}
