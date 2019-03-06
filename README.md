# Setup instructions and cheatsheet
## [Windows](https://drive.google.com/open?id=1ci28j99IGf7X2KIWd249zpmwx-sv8UbxLgbsrIeOkPo)
###Required Softwares

1. Intellij Idea (Community Edition is fine)
2. JDK  8
3. Gradle 3.5 or higher
4. Chromedriver
5. Google chrome

###Setup Instructions
####Git
Download git from https://git-scm.com/download/win
Install with default options

####Java
Download java from url https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Install with default options
Gradle
Download Gradle zip from https://gradle.org/releases/ (download link https://gradle.org/next-steps/?version=5.2.1&format=bin)

Unzip gradle-5.2.1-bin.zip

Create C:\Gradle folder
Copy contents of gradle-5.2.1-bin\gradle-5.2.1 to C:\Gradle

append to Path variable ';C:\Gradle\bin'

####Chromedriver
Download chromedriver from http://chromedriver.chromium.org/downloads suitable for your version of chrome

Unzip chromedriver_win32.zip

Create C:\webdriver folder

Copy file chromedriver.exe from chromedriver_win32 (unzipped folder) to C:\webdriver folder

append to Path variable ';C:\webdriver\bin'

####Intellij idea
`https://www.jetbrains.com/idea/download/#section=windows`
Setup with default options selected

###Test your installation

Open command prompt go to your desirable folder and run following command 

`git clone https://github.com/atmaramnaik/myShop-ft.git`

This will create folder myShop-ft into your folder go into this folder
run command 

`gradle clean build`

if everything is setup ok you will see some selenium test will run after that following output will be shown after build process finishes

BUILD SUCCESSFUL in XXs

In case above thing doesnt happen reach out to us on slack channel
###Cheatsheet

####Pulling dockerized website
`docker pull atmaram/vodqa-2019-sample-site`

####Running dockerized website
`docker run -d -p <Port>:80 atmaram/vodqa-2019-sample-site`

####Dockerized website url
#####Docker for windows
`http://localhost:<Port>`

#####BootToDocker
`http://192.168.99.100:<Port>`

####Cloning Repository
`git clone https://github.com/atmaramnaik/myShop-ft.git`

####Pulling all branches
`git pull --all`

####Pointing code to specific branch (after above)
`git checkout <branch-name>`

E.g.
1. `git checkout 1-start`
2. `git checkout 2-after-factory`
3. `git checkout 3-after-facade`
4. `git checkout 4-after-strategy`
5. `git checkout 5-final`

####Saving local code temporary to stash
`git stash`

####Getting back local code
`git stash pop`

## [Mac](https://drive.google.com/open?id=1fU9MrVA9PrCF2pVk4oalyBPgCr6hGQ4GXWbJdkWOp5c)
###Required Softwares

1. Intellij Idea (Community Edition is fine)
2. JDK  8
3. Gradle 3.5 or higher
4. Chromedriver
5. Google chrome

###Setup Instructions
#### Brew
Follow instructions mention on https://docs.brew.sh/Installation

####Git
`brew install git`

####Java
1. `brew tap caskroom/versions`
2. `brew cask install java8`

####Gradle
`brew install gradle`
####Chromedriver
`brew cask install chromedriver`
####Intellij idea
Download link: https://www.jetbrains.com/idea/download/#section=mac
Setup with default options selected

###Test your installation

Open command prompt go to your desirable folder and run following command 

`git clone https://github.com/atmaramnaik/myShop-ft.git`

This will create folder myShop-ft into your folder go into this folder
run command 

`gradle clean build`

if everything is setup ok you will see some selenium test will run after that following output will be shown after build process finishes

BUILD SUCCESSFUL in XXs

In case above thing doesnt happen reach out to us on slack channel
###Cheatsheet

####Pulling dockerized website
`docker pull atmaram/vodqa-2019-sample-site`

####Running dockerized website
`docker run -d -p <Port>:80 atmaram/vodqa-2019-sample-site`

####Dockerized website url
#####Docker for Mac
`http://localhost:<Port>`

#####BootToDocker
`http://192.168.99.100:<Port>`

####Cloning Repository
`git clone https://github.com/atmaramnaik/myShop-ft.git`

####Pulling all branches
`git pull --all`

####Pointing code to specific branch (after above)
`git checkout <branch-name>`

E.g.
1. `git checkout 1-start`
2. `git checkout 2-after-factory`
3. `git checkout 3-after-facade`
4. `git checkout 4-after-strategy`
5. `git checkout 5-final`

####Saving local code temporary to stash
`git stash`

####Getting back local code
`git stash pop`
## [Ubuntu](https://drive.google.com/open?id=12s9E1gM4wMaZRPQ0xq-H3P_17udPLALWWQBKLkG24_g)
###Required Softwares

1. Intellij Idea (Community Edition is fine)
2. JDK  8
3. Gradle 3.5 or higher
4. Chromedriver
5. Google chrome

###Setup Instructions
####Git
1. `sudo apt-get update`

2. `sudo apt-get install git-core`

####Java
1. `sudo apt-get install software-properties-common`

2. `sudo add-apt-repository ppa:webupd8team/java`

3. `sudo apt update`

4. `sudo apt install oracle-java8-installer`

####Gradle
Download Gradle zip from https://gradle.org/releases/ (download link https://gradle.org/next-steps/?version=5.2.1&format=bin)

Unzip gradle-5.2.1-bin.zip

Create \opt\gradle directory
Copy contents of gradle-5.2.1-bin\gradle-5.2.1 to \opt\gradle

In your ~/.profile file add line at end
PATH=”$PATH:\opt\gradle\bin”


####Chromedriver
Download chromedriver from http://chromedriver.chromium.org/downloads suitable for your version of chrome

Unzip chromedriver_linux64.zip

Create \opt\webdriver directory

Copy file chromedriver from chromedriver_linux64 (unzipped folder) to \opt\webdriver folder

In your ~/.profile file add line
PATH=”$PATH:\opt\webdriver”


####Intellij idea
Download link:`https://www.jetbrains.com/idea/download/#section=linux`
Setup with default options selected


###Test your installation

Open command prompt go to your desirable folder and run following command 

`git clone https://github.com/atmaramnaik/myShop-ft.git`

This will create folder myShop-ft into your folder go into this folder
run command 

`gradle clean build`

if everything is setup ok you will see some selenium test will run after that following output will be shown after build process finishes

BUILD SUCCESSFUL in XXs

In case above thing doesnt happen reach out to us on slack channel
###Cheatsheet

####Pulling dockerized website
`docker pull atmaram/vodqa-2019-sample-site`

####Running dockerized website
`docker run -d -p <Port>:80 atmaram/vodqa-2019-sample-site`

####Dockerized website url
`http://localhost:<Port>`

####Cloning Repository
`git clone https://github.com/atmaramnaik/myShop-ft.git`

####Pulling all branches
`git pull --all`

####Pointing code to specific branch (after above)
git checkout <branch-name>

E.g.
1. `git checkout 1-start`
2. `git checkout 2-after-factory`
3. `git checkout 3-after-facade`
4. `git checkout 4-after-strategy`
5. `git checkout 5-final`

####Saving local code temporary to stash
`git stash`

####Getting back local code
`git stash pop`
