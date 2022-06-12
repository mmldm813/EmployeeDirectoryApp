# EmployeeDirectoryApp

## Build tools & versions used
The build tools used were:
    -appcompat 1.4.2
    -material 1.6.1
    -swiperefreshlayout 1.1.0
    -junit 1.1.3
    -retrofit 2.9.0
    -converter-gson 2.3.0
    -okhttp 4.10.0
    -picasso 2.8
## Steps to run the app
Upon launching the app, there is a scrollable recyclerView that contains a list of Employees. In the list, I have included the small picture of the employee,
the name of the employee, the team name and the phone number. The list is scrollable and there is a placeholder image. 
## What areas of the app did you focus on?
I focused on handling the network request and if the json was malformed or if the list was empty. I also focused on savingInstanceState so that my phone could 
be rotated and not make the network request again.
## What was the reason for your focus? What problems were you trying to solve?
I wanted to focus on handling if the json was malformed so that I could test these use cases. The problems I had were saving the employee list and repopulating it
if the network call was already made
## How long did you spend on this project?
I spent 3 days on this project, about 3 hours each day. Unfortunately, my children and myself had personal health issues that landed us in the hospital, so I could
not focus more time on the app.
## Did you make any trade-offs for this project? What would you have done differently with more time?
I sacrificed my apps architecture in this process. Because of my time constraints health related, I coupled my code very closely together which made it difficult
to test. After submission, I would like to reformat my project to an MVVM architecture and add additional unit tests.
## What do you think is the weakest part of your project?
My app architecture.
## Did you copy any code or dependencies? Please make sure to attribute them here!
I used online examples of how to use retrofit and picasso, also with examples on stackoverflow to handle saving state when doing the phone rotation. 
## Is there any other information you’d like us to know?
I believe this app could definitely be improved upon, and I would like to continue to do so as continued learning. I am a junior level developer that looks forward
to learning best practices and improving my knowledge of app architecture concepts. 