+----------------+           1      *           +----------------+
|   GradeCalculator |<------------------------|    Student     |
|-----------------|                           |----------------|
| +calculateGrade(Student): String            | -id: int       |
| +calculateAverage(Student): double          | -name: String  |
+-----------------+                           | -subjects: List<Subject> |
                                              +----------------+
                                                      |
                                                      | 1..*
                                                      v
                                              +----------------+
                                              |   Subject      |
                                              |----------------|
                                              | -name: String  |
                                              | -marks: double |
                                              +----------------+
