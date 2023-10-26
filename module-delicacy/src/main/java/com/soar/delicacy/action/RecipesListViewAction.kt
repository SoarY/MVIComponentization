package com.soar.delicacy.action

sealed class RecipesListViewAction {
    object GetRecipes: RecipesListViewAction()
}

sealed class RecipesListViewEvent {
    data class ShowToast(val message: String) : RecipesListViewEvent()
}
