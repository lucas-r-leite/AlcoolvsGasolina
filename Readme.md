# AlcoolVsGasolina

AlcoolVsGasolina is a simple Android app that helps users decide whether to fuel their vehicle with ethanol (álcool) or gasoline based on their prices. The app uses Jetpack Compose for its UI.

## Features

- User-friendly interface
- Input fields for gasoline and ethanol prices
- Calculates and displays the better fuel option based on price comparison

## Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/lucas-r-leite/AlcoolvsGasolina
   ```

2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.

## Usage

1. Enter the price of gasoline in the first text field.
2. Enter the price of ethanol in the second text field.
3. Press the "Calcular" button.
4. The app will display whether it is better to fuel with gasoline or ethanol based on the prices provided.

## Code Overview

The main components of the app are:

- `MainActivity`: The main entry point of the app, which sets up the content using Jetpack Compose.
- `AlcoolVsGasolina`: A Composable function that defines the UI and handles user input and calculations.
