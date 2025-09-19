# 📘 String Calculator – Java (JUnit 5)

This project contains a Java implementation of the **String Calculator Kata** with step-by-step extensions (Cases 1–10).  
It uses **JUnit 5** for testing with the `junit-platform-console-standalone` runner.

---

## 📂 Project Structure

```
/Assessment_1 (Project Folder)
│
├── AddListener.java
├── StringCalculator.java
├── StringCalculatorTest.java
├── junit-platform-console-standalone-1.10.0.jar
└── README.md
```

---

## ⚙️ Requirements
- Java 11+ (works with Java 8 too)  
- JUnit 5 Console Standalone JAR (already included in this folder)  

---

## 🛠️ Compile

### Linux / macOS
```bash
javac -cp .:junit-platform-console-standalone-1.10.0.jar *.java
```

### Windows (CMD / PowerShell)
```bat
javac -cp .;junit-platform-console-standalone-1.10.0.jar *.java
```

This will generate `.class` files for all your `.java` files in the same folder.

---

## ▶️ Run Tests

Run the JUnit 5 console launcher to discover and execute all tests:

### Linux / macOS
```bash
java -jar junit-platform-console-standalone-1.10.0.jar --class-path . --scan-classpath
```

### Windows (CMD / PowerShell)
```bat
java -jar junit-platform-console-standalone-1.10.0.jar --class-path . --scan-classpath
```

---

## ✅ Expected Output

If everything compiles and runs correctly, you should see something like:

```
. JUnit Jupiter [OK]
|-- StringCalculatorTest [OK]
|   +-- add_CustomDelimiter_ReturnsSum() [OK]
|   +-- add_NegativeNumber_ThrowsException() [OK]
|   +-- getCalledCount_ReturnsNumberOfAddCalls() [OK]
|   +-- add_EmptyString_ReturnsZero() [OK]
|   +-- add_SingleNumber_ReturnsThatNumber() [OK]
|   +-- add_MultipleNumbers_ReturnsSum() [OK]
|   +-- add_MultipleNegatives_ThrowsExceptionWithAllNegatives() [OK]
|   +-- add_NumbersWithNewlines_ReturnsSum() [OK]
|   +-- add_OccurredEventIsTriggered() [OK]
|   +-- add_NumbersGreaterThan1000_AreIgnored() [OK]
|   +-- add_TwoNumbers_ReturnsSum() [OK]
|   '-- add_CustomDelimiterOfAnyLength_ReturnsSum() [OK]
+-- JUnit Vintage [OK]
'-- JUnit Platform Suite [OK]

Test run finished after 158 ms
[         4 containers found      ]
[         0 containers skipped    ]
[         4 containers started    ]
[         0 containers aborted    ]
[         4 containers successful ]
[         0 containers failed     ]
[        12 tests found           ]
[         0 tests skipped         ]
[        12 tests started         ]
[         0 tests aborted         ]
[        12 tests successful      ]
[         0 tests failed          ]
```

---

