package com.example.gabriele.justjava;

         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.util.Log;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.TextView;

         import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    boolean isChecked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void whippedCreamCheck(View view) {

        CheckBox whippedCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        /*if(whippedCheckBox.isChecked())
            isChecked=true;*/
        isChecked=whippedCheckBox.isChecked();

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        //display(quantity);

        createOrderSummary();

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given price on the screen.
     */

    /*private int displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    public void increment(View view) {
        //TextView quantity_text_view = (TextView) findViewById(R.id.quantity_text_view);
        //int quantity=0;
        quantity++;
        display(quantity);
    }

    public void decrement(View view){
        TextView quantity_text_view = (TextView) findViewById(R.id.quantity_text_view);
        //int quantity=0;
        quantity--;
        display(quantity);
    }

    public void createOrderSummary(){


        TextView order_summary_text_view = (TextView) findViewById(R.id.order_summary_text_view);

        if(order_summary_text_view.getText()=="")
            order_summary_text_view.setText("ORDER SUMMARY\n");


        TextView summary_text_view = (TextView) findViewById(R.id.summary_text_view);
        summary_text_view.setText
                (
                        "Add whipped cream? "+isChecked+"\n"+
                        "Quantity: "+quantity+"\n"+
                        "Total: € "+quantity*5+"\n"+
                        "Thank you!"
                );



    }

}
