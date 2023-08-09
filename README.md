## Oralcle-SQL
This Oracle Express database schema consists of multiple tables representing various aspects of a business application, including client information, addresses, phone numbers, articles, orders, and the association between orders and articles. The schema establishes relationships between entities using foreign key constraints, enabling efficient data management.

         +-------------------+
         |      Client       |
         +-------------------+
         | ID: Integer       |
         | Name: String      |
         +-------------------+
                 |
                 | 1
                 |
         +-------------------+
         |     Address       |
         +-------------------+
         | ID: Integer       |
         | Street: String    |
         | ZipCode: Integer  |
         +-------------------+
          /             \
         / 0..1            \ 1
        /                   \
+-------------------+   +-------------------+
|      Phone        |   |       Order       |
+-------------------+   +-------------------+
| Number: String    |   | ID: Integer       |
+-------------------+   | OrderDate: String |
                        | Address: String   |
                        +-------------------+
                        /            \
                       / 0..*           \ 1
                      /                   \
          +-------------------+  +-------------------+
          |     Article      |  |     Concerned     |
          +-------------------+  +-------------------+
          | Code: Integer    |  | ID: Integer       |
          | Price: Float     |  | OrderID: Integer  |
          | Tax: Float       |  | ArticleCode: Int  |
          | Sample: Integer  |  +-------------------+
          +-------------------+

