# Zakhar_Sytoi_Java_Krakow



## Description

Zakhar_Sytoi_Java_Krakow is a Java library designed to efficiently split market orders, minimizing the number of deliveries required. It utilizes a greedy algorithm for optimal item partitioning and integrates Jackson for seamless JSON parsing. 

## Features

- Fat jar Packaging.
- Jackson for json parsing.
- Greedy algorithm for optimal items splitting.
- 100% coverage.

## Usage

### To use library perform following steps:

  1. Download `Zakhar_Sytoi_Java_Krakow_test_task-1.0.jar` from [here](https://drive.google.com/drive/folders/1rmsF3vxUdVtFrH8whKQ861Pw32qQ7FO8?usp=drive_link).
  2. Put `Zakhar_Sytoi_Java_Krakow_test_task-1.0.jar` iside directory, where you prefere to store you external libraries.
  3. Add dependency to your project:
     - If you use Maven:
       ```
       <dependency>
            <groupId>org.testtask</groupId>
            <artifactId>Zakhar_Sytoi_Java_Krakow_test_task</artifactId>
            <version>1.0</version>
            <scope>system</scope>
            <systemPath>${pathToLibrary}/Zakhar_Sytoi_Java_Krakow_test_task-1.0.jar</systemPath>
        </dependency>
       ```
     - If you use Gradle:
       ```
       dependencies {
            implementation files('path/to/library/Zakhar_Sytoi_Java_Krakow_test_task-1.0.jar')
        }
       ```
  4. Import and use:
     ```
     import org.testtask.BasketSplitter;
     class Example{
        public void exampleUse(){
                BasketSplitter basketSplitter = new BasketSplitter("/path/to/your/config/dir/config.json");
        
                List<String> items = List.of("Garlic - Peeled", // items you want to split
                        "Spinach - Frozen",
                        "Cake - Miini Cheesecake Cherry",
                        "Chickhen - Chicken Phyllo");
                        
                Map<String, List<String>> result = basketSplitter.split(items);
       }    
      }
     ```

## Tests
1. Clone this repository.
2. Execute the following command in project root directory (You need to have Maven installed):

   `$ mvn test`

## Contact

For questions or inquiries, please contact [Zakhar Sytoi](mailto:zakharsytoi@gmail.com).
