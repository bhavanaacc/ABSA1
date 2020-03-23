# ABSA
aspect based sentiment analysis
Upload dataset
Removew stopwords
Stemming
Feature selection
(All list has created for each aspect  FoodF, ServiceF etc) => During feature selection

[TF]
Frequncy has updated based on available count (frequency (id, aspect, term, frequency)) => TF calculation button click
Unique features has selected and created list (FoodTF, ServiceTF etc)  same time we store all data in another list (AllinTFOne)

[TF-IDf with CO]
Note : TF features has taken >=(?)
carried out all TF list like  (FoodTF, ServiceTF etc) and calculate co-occurance matirx 
calculate the co-occurance weight in last column (using corelation weight)

[WEIGHTED MATRIX]
carried out all TF list like  (FoodTF, ServiceTF etc) and  calculate the weight for each term 

Term (T) weight = TF(t) in same aspect category  / TF(t) in all aspect category then
insert into weighted (aspect,term,food,othercount,weight) and update weight based co-occurance (Weighted Table)
