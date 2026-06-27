# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
Name: Farrel Brilliant Mangkey
Student ID: 5026251065
Class: E

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing. The application includes a login system, game statistics tracking, and a Top 5 scorer feature. The player competes against the computer, which makes its move by randomly selecting an available cell. All player data and statistics are stored in a single-table MySQL database.

## Features
- Login using database (username and password validation)
- Play Tic-Tac-Toe using Swing GUI (3x3 button board)
- Record wins, losses, draws, and score after every completed game
- Display personal statistics (My Statistics window)
- Display Top 5 scorers using JTable, sorted by score (and wins as tiebreaker)
- Navigation between Login, Main Menu, Game, Statistics, and Top Scorers windows

## Scoring System
| Result | Score Change |
|--------|--------------|
| Win    | +10 points   |
| Draw   | +3 points    |
| Lose   | +0 points    |

## Database
Database used: MySQL

The application uses a single table named `players`, which stores both login credentials and game statistics (wins, losses, draws, score).

## How to Run
1. Create the database and table by importing `schema.sql` (located in the `database/` folder) into your MySQL server.
2. Open the Java project in your preferred IDE or editor (e.g. VS Code).
3. Add the MySQL JDBC driver (`mysql-connector-j`) to the project classpath.
4. Configure `DatabaseManager.java` with your own database URL, username, and password.
5. Compile all files in the `src/` folder.
6. Run `Main.java` to start the application.

Example commands (Windows PowerShell):
```
javac -cp "lib\mysql-connector-j-8.0.33.jar" -d bin src\*.java
java -cp "bin;lib\mysql-connector-j-8.0.33.jar" Main
```

## Default Login Accounts
| Username  | Password |
|-----------|----------|
| student1  | 12345    |
| student2  | 12345    |
| student3  | 12345    |
| student4  | 12345    |
| student5  | 12345    |

## Class Explanation

**Main**
Entry point of the application. Starts the program by opening the `LoginFrame` on the Swing event dispatch thread.

**DatabaseManager**
Handles the JDBC connection to the MySQL database. Stores the database URL, username, and password, and provides a `getConnection()` method used by other classes.

**Player**
A simple model class that stores player data: id, username, wins, losses, draws, and score. Used to pass player information between classes after login and during gameplay.

**PlayerService**
Handles all database operations related to players:
- `login(username, password)` — validates credentials against the database and returns a `Player` object if successful.
- `updateStatistics(player, result)` — updates wins, losses, draws, and score in the database after a game ends.
- `getTopFiveScorers()` — retrieves the top 5 players ordered by score (and wins as a tiebreaker) for the leaderboard.

**GameBoard**
A simple model class that stores the state of the 3x3 game board as a character array, representing each cell as empty, X, or O.

**GameLogic**
Handles the core game rules:
- `makeMove(index, symbol)` — validates and places a move on the board.
- `checkWinner(symbol)` — checks all winning patterns (rows, columns, diagonals).
- `isDraw()` — checks whether the board is full with no winner.
- `computerMove()` — selects a random empty cell for the computer's move.

**LoginFrame**
The Swing window where the user enters their username and password. On clicking Login, it calls `PlayerService.login()`. If successful, it opens `MainMenuFrame`; otherwise, it shows an error dialog using `JOptionPane`.

**MainMenuFrame**
The main menu window shown after a successful login. Provides navigation buttons to Start Game, View My Statistics, View Top 5 Scorers, and Exit.

**GameFrame**
The Swing window where the Tic-Tac-Toe game is played. Connects the 9 board buttons to `GameLogic`, handles the player's move, triggers the computer's move, checks for win/lose/draw conditions, and calls `PlayerService.updateStatistics()` once the game ends.

**StatisticsFrame**
Displays the currently logged-in player's personal statistics (username, wins, losses, draws, and score) retrieved from the `Player` object.

**TopScorersFrame**
Displays the Top 5 scorers retrieved from the database using a `JTable`, showing username, wins, losses, draws, and score for each top player.

## Screenshots
Add screenshots here.
(Place screenshots in the `screenshots/` folder and reference them below, e.g.)
```
<img width="442" height="255" alt="image" src="https://github.com/user-attachments/assets/a76fcf2a-2973-40eb-bc06-c5f5611fb983" />
<img width="481" height="547" alt="image" src="https://github.com/user-attachments/assets/c8d5a13c-181f-427a-a23c-5d64c948fdd6" />
<img width="485" height="362" alt="image" src="https://github.com/user-attachments/assets/0dad1f78-3a17-485f-9e63-d61b80fe8fb0" />

## GitHub Repository Link


## Video Link
YouTube: (paste your YouTube video link here)
