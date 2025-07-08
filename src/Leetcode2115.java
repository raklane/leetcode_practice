import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2115 {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, Boolean> readyRecipes = new HashMap<>();
        List<String> suppliesList = new ArrayList<>(List.of(supplies));
        List<String> recipesList = new ArrayList<>(List.of(recipes));
        List<String> currentIngredientList = new ArrayList<>();
        findRecipes(recipesList, ingredients, suppliesList, readyRecipes,currentIngredientList, 0);
        List<String> possibleRecipes = new ArrayList<>();
        for(String recipe : readyRecipes.keySet()){
            if(readyRecipes.get(recipe))
                possibleRecipes.add(recipe);
        }
        return possibleRecipes;

    }

    public boolean findRecipes(List<String> recipesList, List<List<String>> ingredients, List<String> suppliesList, Map<String, Boolean> readyRecipes,List<String> currentIngredientList, int i) {

        if(i>=recipesList.size())
            return true;
        String recipe = recipesList.get(i);
        if(currentIngredientList.contains(recipe))
            return false;
        List<String> ingredientForThisRecipe = ingredients.get(i);
        boolean possible = true;
        for (String ingredient : ingredientForThisRecipe){
            if(suppliesList.contains(ingredient))
                continue;
            Boolean possibleRecipe = readyRecipes.get(ingredient);
            if(possibleRecipe != null){
                if(possibleRecipe)
                    continue;
                else{
                    possible = false;
                    break;
                }
            }
            if(recipesList.contains(ingredient)){
                currentIngredientList.add(recipe);
                if(findRecipes(recipesList, ingredients, suppliesList, readyRecipes,currentIngredientList, recipesList.indexOf(ingredient)))
                    continue;
                else{
                    possible = false;
                    break;
                }
            }
            possible = false;
        }
        if(possible)
            readyRecipes.put(recipe, true);
        else
            readyRecipes.put(recipe, false);
        currentIngredientList.clear();
        findRecipes(recipesList,ingredients,suppliesList,readyRecipes,currentIngredientList,i+1);
        return true;

    }


}
