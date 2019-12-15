class with measures: <b>com.bushemi.Main</b>
Different strategies in different order. Numbers in nanos.

with given parameters <br/>
    private static final int <b>TOTAL_TRIES = 5000000</b>;<br/>
    private static final int <b>LIST_SIZE = 10000</b>;<br/>
there was such numbers:<br/>
for each with Parallel Stream = (finish-start)/TOTAL_TRIES = <b>15920</b><br/>
for Iterator = (finish-start)/TOTAL_TRIES = <b>12949</b><br/>
for E = (finish-start)/TOTAL_TRIES = <b>12852</b><br/>
for each with Stream = (finish-start)/TOTAL_TRIES = <b>17008</b><br/>
for Each = (finish-start)/TOTAL_TRIES = <b>12445</b><br/>
for i = (finish-start)/TOTAL_TRIES = <b>12558</b><br/>