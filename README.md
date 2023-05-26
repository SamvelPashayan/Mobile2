<p align = "center">МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ
РОССИЙСКОЙ ФЕДЕРАЦИИ
ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ
ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ
«САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ»</p>
<br><br><br><br><br><br>
<p align = "center"> Институт естественных наук и техносферной безопасности <br> Кафедра информатики <br> Пашаян Самвел Алексанович </p>
<br><br><br>
<p align = "center"> Лабораторная работа №2 <br> «Android и модель MVC» <br> 01.03.02 Прикладная математика и информатика</p>
<br><br><br><br><br><br><br><br><br><br><br><br>
<p align = "right"> Научный руководитель <br>
Соболев Евгений Игоревич</p>
<br><br><br>
<p align = "center">  г. Южно-Сахалинск <br> 2023г. </p>

***
# <p align = "center"> 1. Добавление слушателя для TextView </p>
Кнопка NEXT удобна, но было бы неплохо, если бы пользователь мог переходить к следующему вопросу простым нажатием на виджет TextView. 
Подсказка. Для TextView можно использовать слушателя View.OnClickListener, который использовался с Button, потому что класс TextView также является производным от View. 
***
## <p align = "center"> РЕШЕНИЕ </p>
            questionTextView.setOnClickListener{
            updateQuestion()
            }
# <p align = "center"> 2. Добавление кнопки возврата </p>
Добавьте кнопку для возвращения к предыдущему вопросу. Пользовательский интерфейс должен выглядеть примерно так, как показано на рис. 2.13. 
***
## <p align = "center"> РЕШЕНИЕ </p>
            prevButton.setOnClickListener {
            backQuestion()
            }

            private fun backQuestion() {
            currentIndex = (currentIndex - 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
            }
# <p align = "center"> 3. От Button к ImageButton </p>
Возможно, пользовательский интерфейс будет смотреться еще лучше, если на кнопках будут отображаться только значки, как на рисунке
***
## <p align = "center"> РЕШЕНИЕ </p>
        private lateinit var nextButton:ImageButton
        private lateinit var prevButton:ImageButton

        <ImageButton
            android:id="@+id/prev_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:backgroundTint="#673AB7"
            android:src="@drawable/arrow_left" />

        <ImageButton
            android:id="@+id/next_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:backgroundTint="#673AB7"
            android:src="@drawable/arrow_right"
            android:textAlignment="textEnd" />

## <p align = "center"> ВЫВОД </p>      
Итогом работы стало создание мобильного Android приложения по схеме MVC, при которой приложение и управляющяя логика делятся на три отдельных компонента: модель, представление и контроллер. Это позволяет сделать вывод, что цель данной лабораторной работы успешно достигнута
***  
![](LAB2.png)