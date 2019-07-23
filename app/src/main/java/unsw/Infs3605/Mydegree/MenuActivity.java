package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MenuActivity extends MainActivity {

    ListView listView;
    private static final String TAG = "Menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        appBarTxt.setText("Learning Point");

        Log.d(TAG, "Menu Create: starts");

        final String[] topicHeadingLevelOneArray = {
                "Menu 1: Gym day meal",
                "Menu 2: Happy foodie",
                "Menu 3: Green heaven",
                "Menu 4: Stealious",
                "Menu 5: Juicy day",

        };

        final String[] topicHeadingLevelTwoArray = {
                "this plan recommend for gym person",
                "how to cook delicous snakes",
                "vegetarian's favourite",
                "ramsay's 3 minutes steak",
                "daily healthy smoothies or juice plan",

        };

        final String[] topicContent = {
                // Menu 1
                "Breakfast: Toast With Egg And Avocado Salsa.\n" +
                        "\n" +
                        "   Ingredients:\n" +

                        "       - ½ avocado, peeled and cubed\n" +
                        "       - 1 roma tomato, seeded and finely diced\n" +
                        "       - 1 Tbs lime juice\n" +
                        "       - 1 Tbs finely diced coriander\n" +
                        "       - 2 tsp sweet chilli sauce\n" +
                        "       - 2 poached eggs\n" +
                        "       - Toasted Bürgen® Soy-Lin®\n" +
                        "\n" +
                        "   To make the salsa:\n" +
                        "       1.combine avocado, tomato, lime juice and coriander in a small bowl and mix lightly.\n" +
                        "       2.Serve salsa with a poached egg, toast and a drizzle of sweet chilli sauce.\n" +

                        "\n" +
                        "\n" +
                        "\n" +


                        "Lunch: Beef And Pearl Barley Salad With Fresh Chimichurri.\n" +
                        "\n" +
                        "   Ingredients:\n" +

                        "       - 100g beef topside roast, lean, roasted and sliced\n" +
                        "       - 60g (approx. 1/3 cup) pearl barley, uncooked\n" +
                        "       - 1 ½ cup spinach, shredded\n" +
                        "       - ¼ medium red onion, finely diced\n" +
                        "       - 100g cherry tomatoes, halved\n" +
                        "       - juice and zest of ¼ lemon\n" +
                        "       - 1 tsp extra virgin olive oil\n" +
                        "       - 1 tsp white wine vinegar\n" +
                        "       - 1 tsp chopped flat-leaf parsley, finely chopped\n" +
                        "       - 1 tsp chopped fresh coriander, finely chopped\n" +
                        "       - 1 garlic clove, crushed\n" +
                        "       - pinch red chilli flakes\n" +

                        "\n" +
                        "   Method:\n" +
                        "       1.Bring a small pot of water to the boil, and cook the barley for 25 minutes, or until cooked through. Alternatively, you can place it in a microwave-safe bowl, cover with water, and then place cling film tightly over the bowl. Make a cut in the cling film to allow steam to escape, then microwave on a low heat for 10-15 minutes, until the barley is tender and has absorbed all the water.\n" +

                        "       2.Rinse with cool running water in a sieve or colander, and drain.\n" +

                        "       3.Combine the barley, salad greens, cherry tomatoes, lemon zest, juice, and onion in a bowl and toss to combine.\n" +
                        "       4.In a small mixing bowl, combine the chimichurri ingredients—parsley, coriander, chilli flakes, garlic, oil, and vinegar—and stir well.\n" +
                        "       5.Top the barley salad with beef slices, then spoon over the chimichurri to serve.\n" +

                        "\n" +
                        "\n" +
                        "\n" +

                        "Dinner: Pastry-Free Rice And Veggie Pie\n" +
                        "\n" +
                        "   Ingredients:\n" +

                        "       - ¾ cup Low GI brown rice\n" +
                        "       - 1 tablespoon olive oil\n" +
                        "       - 2 large free range eggs\n" +
                        "       - 1 cup reduced-fat milk\n" +
                        "       - 1 cup grated zucchini, squeezed\n" +
                        "       - 1 cup, packed, chopped spinach\n" +
                        "       - 2/3 cup frozen peas\n" +
                        "       - 3 tablespoons chopped parsley\n" +
                        "       - 1 ½ cups ricotta cheese\n" +

                        "\n" +
                        "   Method:\n" +

                        "       1.Preheat oven to 180 C (fan 160C). Lightly grease a 22 cm round ovenproof pie dish with olive oil or line the base and sides of a 22 cm spring form pan with baking paper.\n" +
                        "       2.Cook rice according to instructions on-pack and set aside to cool.\n" +
                        "       3.In a large bowl whisk together the eggs and milk. Add the rice, zucchini (make sure as much liquid as possible is squeezed out), spinach, peas, parsley and ricotta. Season to taste and blend thoroughly.\n" +
                        "       4.Fill into pie dish and bake about 30 minutes or until the point of a fine bladed knife inserted in middle comes out clean. Let stand 10 minutes before serving.\n",



                //  Menu 2
                "Strawberry Yoghurt Crunch:\n" +

                        "\n" +
                        "   Ingredients:\n" +

                        "       - 50 g (13/4 oz) mixed raw nuts, such as cashews, peanuts, pistachios and almonds\n" +
                        "       - 15 g (1/2 oz) sunflower seeds\n" +
                        "       - 15 g (1/2 oz) pepitas (pumpkin seeds)\n" +
                        "       - 600 g (1 lb 5 oz) low fat natural yoghurt\n" +
                        "       - 1 large mango, sliced\n" +
                        "       - 200 g (7 oz/11/3 cups) strawberries, sliced\n" +
                        "       - 4 teaspoons pure floral honey\n" +



                        "\n" +
                        "   Method:\n" +

                        "       1.Heat a non-stick frying pan over medium heat and add the raw nuts and seeds. Dry-fry them for 1–2 minutes, stirring continuously until browned (take care as the nuts will burn very quickly). Remove from the heat and, when cool enough to handle, roughly chop with a large knife.\n" +
                        "       2.Take four glasses and spoon a little yoghurt into the bottom of each one. Divide the mango slices between the glasses, top with another layer of yoghurt, then finish with a layer of sliced strawberries.\n" +
                        "       3.Drizzle the honey over the strawberries and sprinkle the toasted nut and seed mixture over the top.\n"+
                        "\n" +
                        "\n" +
                        "\n" +

                        "Full-Of-Fruit Muffins:\n" +
                        "\n" +
                        "   Ingredients:\n" +

                        "       - 2 cups (300g/10 ½ oz) self-raising flour\n" +
                        "       - 1 teaspoon baking powder\n" +
                        "       - 1 ½ teaspoon ground cinnamon\n" +
                        "       - ½ cup (55grams/2ounces) unprocessed oat bran\n" +
                        "       - 1 large ripe banana\n" +
                        "       - 1 apple (such as Granny Smith, Royal Gala or Golden Delicious), unpeeled\n" +
                        "       - 150grams (5 1/4 ounces) fresh or thawed frozen mixed berries or blueberries\n" +
                        "       - ½ cup (125ml/fl ounces) pure floral honey\n" +
                        "       - 2 eggs, lightly whisked\n" +
                        "       - ¼ cup (60ml/2fl ounces) buttermilk\n" +
                        "       - 100ml (3 1/2fl ounces) canola oil\n" +


                        "\n" +
                        "   Method:\n" +

                        "       1.Preheat oven to 190°C (375°F/Gas 5). Line 2 x 12-hole patty pan trays with paper cases\n" +
                        "       2.Sift together the flour, baking powder and cinnamon into a large mixing bowl. Stir in the oat bran. Make a well in the centre and set aside.\n" +
                        "       3.Use a fork to mash the banana in a medium sized bowl. Core and coarsely grate the apple and add to the banana. Add the berries, honey, eggs, buttermilk and oil and stir well to combine. Add the fruit to the flour mixture and fold together with a large metal spoon until just combined.\n" +
                        "       4.Spoon the mixture evenly into the lined patty pans and bake for 20-25 minutes or until a skewer inserted into one of the muffins comes out clean. Remove from oven and transfer to a wire rack. Serve warm or at room temperature.\n" +
                        "       * Cook’s tips: These muffins will keep in an airtight container at room temperature for up to 2 days. To freeze, wrap the muffins individually in plastic wrap and then freeze in sealed freezer bags or an airtight container for up to a month. Thaw at room temperature.\n",

                // Menu 3
                "Fresh Kale, Avocado And Pomegranate Salad:\n" +

                        "\n" +
                        "   Ingredients:\n" +

                        "       - 300 g (10½ oz) curly kale leaves stripped from their stem\n" +
                        "       - ¼ cup lemon juice (about 1 juiced lemon)\n" +
                        "       - 3 tablespoons extra virgin olive oil\n" +
                        "       - ½ teaspoon salt\n" +
                        "       - 1 avocado, cut into small cubes\n" +
                        "       - ½ cup pomegranate seeds\n" +




                        "\n" +
                        "   Method:\n" +

                        "       - Wash kale leaves thoroughly, in several changes of water. Press down firmly or use a salad spinner to remove excess water.\n" +
                        "       - Roll up leaves and shred very finely, then transfer to a large salad bowl.\n" +
                        "       - Add lemon juice, oil and salt, and massage well with a clean hand for a few minutes until kale softens. Allow to sit for at least 30 minutes for flavour to develop.\n" +
                        "       - Prior to serving, fold in avocado and pomegranate seeds. Salad will keep in fridge for up to 2 days. Recipe is unsuitable for freezing.\n" +
                        "\n" +
                        "   TIP:\n" +
                        "       – Clean organic kale carefully as it sometimes hides slugs, snails and aphids on the leaves. Submerge it in salted water for half an hour if required, then rinse several times.\n" +

                        "       – Shepard avocado is the only variety of avocado that doesn’t turn brown when cut. It has a smooth, green skin and buttery flesh.\n" +

                        "       – Variation: Swap cubed mango for pomegranate seeds.\n"+


                        "Carisma Potato Salad:\n" +

                        "\n" +
                        "   Ingredients:\n" +

                        "       - 600g Carisma potatoes unpeeled, washed\n" +
                        "       - Medium bunch (about 130g) rocket, ends trimmed, washed, dried\n" +
                        "       - Freshly ground black pepper\n" +
                        "       - 1 tablespoon roughly chopped fresh continental parsley\n" +
                        "       - Olive Vinaigrette\n" +
                        "       - 2 tablespoons olive oil\n" +
                        "       - 1 tablespoon kalamata olive paste\n" +
                        "       - 1 teaspoon red wine vinegar\n" +
                        "       - 1 teaspoon Dijon mustard\n" +





                        "\n" +
                        "   Method:\n" +

                        "       - Wash kale leaves thoroughly, in several changes of water. Press down firmly or use a salad spinner to remove excess water.\n" +
                        "       - Roll up leaves and shred very finely, then transfer to a large salad bowl.\n" +
                        "       - Add lemon juice, oil and salt, and massage well with a clean hand for a few minutes until kale softens. Allow to sit for at least 30 minutes for flavour to develop.\n" +
                        "       - Prior to serving, fold in avocado and pomegranate seeds. Salad will keep in fridge for up to 2 days. Recipe is unsuitable for freezing.\n" +
                        "\n" +
                        "   TIP:\n" +
                        "       – Clean organic kale carefully as it sometimes hides slugs, snails and aphids on the leaves. Submerge it in salted water for half an hour if required, then rinse several times.\n" +

                        "       – Shepard avocado is the only variety of avocado that doesn’t turn brown when cut. It has a smooth, green skin and buttery flesh.\n" +

                        "       – Variation: Swap cubed mango for pomegranate seeds.\n",

                "Steak:\n" +

                        "\n" +
                        "   Ingredients:\n" +

                        "       - raw steak\n" +
                        "       - 10g salt\n" +
                        "       - 3 tablespoons extra virgin olive oil\n" +
                        "       - 10g black pepper\n" +
                        "       - rosemary\n" +
                        "       - 20g butter\n" +




                        "\n" +
                        "   Method:\n" +

                        "       - seasoned the steak first with salt and black pepper\n" +
                        "       - hot the pan with oliver oil around 5 mins\n" +
                        "       - put the steak into the hot pan, after the steak color changed, put butter and rosemary in\n" +
                        "       - if you like, you can also add garlic in last step\n",



                // Menu 5
                "Cucumber Apple Mint Smoothie:\n" +

                        "\n" +
                        "   Ingredients:\n" +

                        "       - 1 large cucumber, peeled and sliced\n" +
                        "       - ¼ cup  mint leaf (10 g)\n" +
                        "       - 1 green apple, diced\n" +
                        "       - 1 tablespoon  honey\n" +
                        "       - ½ avocado, diced\n" +
                        "       - 1 ½ cups  ice (210 g)\n" +





                        "\n" +
                        "   Method:\n" +

                        "       - Place the cucumber, mint, apple, honey, and avocado in a blender or food processor and blend until just combined.\n" +
                        "       - Add in the ice and continue to blend until the mixture is smooth.\n" +
                        "       - Serve immediately.\n"+
                        "\n" +
                        "\n" +
                        "\n" +

                        "Strawberry Banana Smoothie:\n" +

                        "\n" +
                        "   Ingredients:\n" +

                        "       - 2 cups  strawberry, sliced (300 g)\n" +
                        "       - 1 banana, sliced\n" +
                        "       - 1 ½ cups  milk, of choice (360 mL)\n" +
                        "       - 1 cup  plain greek yogurt (285 g)\n" +






                        "\n" +
                        "   Method:\n" +

                        "       - Put fruit in a freezer bag. Seal and store in freezer for up to 8 -12 months.\n" +
                        "       - When ready to use, put milk, Greek yogurt, and frozen fruit into a blender and mix until consistency is smooth.\n",
                "\n" +
                        "\n" +
                        "\n" +

                        "Blueberry Banana Spinach Smoothie\n" +

                        "\n" +
                        "   Ingredients:\n" +

                        "       - 1 cup  blueberry (100 g)\n" +
                        "       - 1 cup  baby spinach (225 g)\n" +
                        "       - 1 banana, chopped\n" +
                        "       - 1 ½ cups  ice (210 g)\n" +






                        "\n" +
                        "   Method:\n" +

                        "       - Place the blueberries, spinach, and banana in a blender or food processor and blend until just combined.\n" +
                        "       - Add in the ice and continue to blend until the mixture is smooth.\n" +
                        "       - Serve immediately.\n",
        };

        final String[] youtubeVideoId = {
                "G6e7rqK7d6I",
                "UTTfY8o1gfM",
                "HzUXRIIg50Q",
                "AmC9SmCBUj4",
                "YuDhbLQtt2k",

        };

        MenuAdapter newMenuAdapter = new MenuAdapter(this, topicHeadingLevelOneArray, topicHeadingLevelTwoArray, topicContent);
        listView = (ListView) findViewById(R.id.menu_listview);
        listView.setAdapter(newMenuAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuActivity.this, MenuDetail.class);
                String message = topicHeadingLevelOneArray[position];
                String message2 = topicContent[position];
                String message3 = youtubeVideoId[position];
                intent.putExtra("topic", message);
                intent.putExtra("content", message2);
                intent.putExtra("videoid", message3);
                startActivity(intent);

            }
        });
        Log.d(TAG, "Create end");

    }
}
