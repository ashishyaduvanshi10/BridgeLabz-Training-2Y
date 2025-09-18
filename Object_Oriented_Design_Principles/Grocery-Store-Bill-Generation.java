+-----------------+          1      *        +----------------+
|   Customer      |-----------------------> |   Order        |
|-----------------|                         |----------------|
| -id:int         |                         | -products:List<Product> |
| -name:String    |                         | -customer:Customer |
+-----------------+                         +----------------+
                                                   |
                                                   | 1..*
                                                   v
                                              +----------------+
                                              |   Product      |
                                              |----------------|
                                              | -name:String   |
                                              | -qty:double    |
                                              | -pricePerUnit:double |
                                              +----------------+
