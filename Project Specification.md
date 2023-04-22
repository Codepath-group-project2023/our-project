# Project Specification
# **Meal Master**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview
### Description 
The app will allow users to find new and unique recipes provided by the chosen API. Depending on the API, users will be able to search through different recipes based on personal needs. For example, they can search by recipe name, country of origin, main ingredient, etc. There will also be a section where users can view their favorite recipes, providing easy access to them. Finally, if a user doesn't know what they want to make, they can click the random recipe generator!  

### App Evaluation

<!-- This is taken from the brainstorming hackMD doc -->

- **Category:** Food / Health / Fitness
- **Mobile:** Rather than going through different websites to find a recipe for biriyani, you can find whatever you need in one app
- **Story:** This app would allow chefs of varying expertise to try and cook new recipes. It would also allow users to track favorite recipes to refer back to at any time.
- **Market:** Potential users for this app can be anyone wanting to improve their palate. Examples include, me, you, and even Gordon Ramsay!
- **Habit:** The app could encourage users such as Paulina Ramos to browse and search for recipes on a daily basis, as well as plan their meals for the week and create a shopping list.
- **Scope:** Difficulty 7/10 because the app would require a database of recipes, as well as a way for users to search and maybe filter them based on ingredients, cooking time, dietary restrictions. The scope would increase further if the app included user-generated content, such as allowing users to upload their own recipes or rate and review existing ones. It's like yelp - but for recipes!

## Product Spec

### 1. User Features (Required and Optional)

Required Features:
- users can look up recipes by name
- users can see details of the recipe after clicking on it
- recycler view
- multiple user action points

Stretch Features:
- night theme (can do)
- toast (can do) [pops up when you add to favorites]
- nav bar (can do)
- custom fonts (can do)
- users can filter recipes (nice to have)
- users can add recipes to favorites (nice to have)
- button that gives users a random recipe (nice to have)
- users can input number of servings and ingredients list will be adjusted accordingly to the input (nice to have)
- users can upload their own recipes (nice to have)
- users can upload images of how their food turned out pertaining to a recipe (nice to have)
- users can follow other users who post recipes they are interested in (nice to have)
- users can comment and ask questions under recipes posted (nice to have)
- recommended recipes for each user (nice to have)

### 2. Chosen API(s)
- **Search meal by Name:** **www.themealdb.com/api/json/v1/1/search.php?s=[enter name]**
    - Users inputs a name
    - User can filter recipes
    - User can find a random recipe

- Additional API if necessary: 
    - https://rapidapi.com/spoonacular/api/recipe-food-nutrition/

### 3. User Interaction

Required Feature

- Get Recipe: user can click basic categories on screen  
  - user can click one of the main categories
      - recipes will appear pertaining to that category
- Get Recipe: users can search different recipes 
  - user can enter recipe name in search bar
      - recipes will appear pertaining to what the user enters
- Add to Favorites: user can add a recipe to a favorite list 
    - user can click a heart button 
        - recipe will be automatically added to a list 
- Filter: user can click button to get a random recipe
    - user can click "random" button
        - a random recipe will appear on the screen

        
## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="https://i.imgur.com/SzzQkaM.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Build Notes

Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  

For Milestone 2, include **2+ GIFs** of the build process here!

## License

Copyright **2023** **CARA GAEL LUBNA KAZI**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.