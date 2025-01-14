# Maven Project: SpeedyAir

This project is a Java application built with Maven. The instructions below will guide you through the steps necessary to set up and run the project locally.

## Prerequisites

Ensure you have the following installed on your system:

1. **Java Development Kit (JDK):**

   - Version 8 or later is required.
   - Verify installation by running:
     ```bash
     java -version
     ```

2. **Apache Maven:**
   - Install Maven and ensure it is added to your system's PATH.
   - Verify installation by running:
     ```bash
     mvn -version
     ```

## Steps to Run the Application Locally

1. **Clone the Repository:**
   Clone the project repository:

   ```bash
   git clone https://github.com/Ricardsss/speedy-air.git
   ```

2. **Navigate to the Project Directory:**
   Change to the directory where the project is located:

   ```bash
   cd speedy-air
   ```

3. **Build the Project:**
   Compile and resolve all dependencies using Maven:

   ```bash
   mvn clean install
   ```

4. **Run the Application:**
   Use the following Maven command to run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.speedyAir.App"
   ```
