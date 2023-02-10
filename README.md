# FarmProject
Итоговая аттестация GeekBrains

Создаём публичный репозиторий github. Инициируем папку проекта
cd Documents/Developing/FarmProject git init

Создаём и заполняем текстовые файлы для будущей базы данных
cat > pets.txt cat, Ryzhik, 03.2012, red
dog, Sharik, 05.2018, black
hamster, Dusya, 11.2022, white
Ctrl+D

cat > beasts.txt
horse, Lady, 01.2018, brown
camel, Sharuf, 11.2016, beige
donkey, Lucky, 03.2020, grey Ctrl+D

Объединяем их в единый файл
cat pets beasts > animals.txt

Переименовываем этот файл, создаём папку и переносим файл в папку
mv animals.txt > Друзья_человека.txt
mkdir textfiles
mv Друзья_человека.txt textfiles

Создаём первый коммит git add . 
git commit -m "Text files added"
git remote add origin https://github.com/yukka-yu/FarmProject
git push origin main

Создаём UML диаграмму.
Далее переходим к работе с mySQL, создаём новую ветку, работаем со скриптом,
сохраняемся и коммитим новую ветку, пушим её в репозиторий, принимаем пуллреквест.
Далее работаем с программой на java в новой ветке java, также отправляем её на гитхаб.
