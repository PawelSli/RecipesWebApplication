generateIngredientButton=document.querySelector('#generateIngredientsButton');
generateStepsButton=document.querySelector('#generateStepsButton');
ingredientDiv=document.querySelector('#ingredients');
stepsDiv=document.querySelector('#steps');


function generateIngredients(){
    removeAllElement('#ingredients');
    numbersOfIngredients=document.querySelector('#generateIngredientsInput').value;
    if(numbersOfIngredients==0){
        numbersOfIngredients=1;
        document.querySelector('#generateIngredientsInput').setAttribute('value','1');
    }

    for(i=0;i<numbersOfIngredients;i++){
        const template = document.querySelector("#ingredient-template");
        const clone =template.content.cloneNode(true);
        label=clone.querySelector('label.text-info');
        label.innerHTML='Ingredient nr '+(i+1);
        ingredientDiv.appendChild(clone);
    }
}

function generateSteps() {
    removeAllElement('#steps');
    numbersOfSteps=document.querySelector('#generateStepsInput').value;
    if(numbersOfSteps==0){
        numbersOfSteps=1;
        document.querySelector('#generateStepsInput').setAttribute('value','1');
    }
    for(i=0;i<numbersOfSteps;i++){
        const template = document.querySelector("#step-template");
        const clone =template.content.cloneNode(true);
        label=clone.querySelector('label');
        label.innerHTML='Description - Step '+(i+1);
        stepsDiv.appendChild(clone);
    }
}

function removeAllElement(divId){
    const elements = document.querySelector(divId);
    elements.textContent = '';
}

generateIngredientButton.addEventListener("click",generateIngredients);
generateStepsButton.addEventListener("click",generateSteps);