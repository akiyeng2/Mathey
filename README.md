#Group 5 Mathey Project 

###Group Members
* Jordan Cho
* Amalan Iyengar
* Devin Williams
* Lauren Koval
* Jacob Rayfield

This is the code repository, as well as the documentation, for our group Mathey Project. All code will be committed to this repository. The advantage to using this is that we can have all of our code in one centralized location, and if something messes up, we have all of the previous versions to go back and look through, and if someone loses their code, we will all have it here. It will also allow us to see what people are doing
<hr/>
##Instructions
1. First of all, everyone needs to get an account on GitHub. 
2. Once that is done, please send me your account name and I will add you as a contributor.
3. To get started, read through <a href="https://help.github.com/articles/set-up-git">the Set Up Git Page</a>
4. There is also a GUI application for <a href="http://windows.github.com/">Windows</a> as well as <a href="http://mac.github.com/">Mac OSX</a> if you don't want to use command line.
5. Once I have added you as a collaborator, clone the repo onto your local machine, either by going to the repo and hitting the "Clone in Desktop" button, or typing `git clone https://github.com/scrblnrd3/Mathey.git` in command line in the location you want to store the repo
6. It gets easier from here. Store all your code in the `src/` directory, and whenever you've added a new file or made substantial changes, commit locally. You can do this by either typing `git commit -am "message"` in  terminal(please add substantial messages). Alternatively, in the dekstop app, you can just hit the commit button
7. After committing, you need to push the changes to the online repo. Do this by typing `git push` in Command Line, or in the desktop app, hit the "Sync" button.
8. To download the latest code, type in `git pull` in Command Line or hit the Sync button in the desktop app
9. Now everyone in the group has the code for the entire group!

If all else fails, we can just email our code to each other, or put it in <a href="http://pastebin.com/">Pastebin</a> or a similar site.

##Documentation

We'll be writing documentation for the <a href="http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html">Javadoc tool</a>. This way, we can just have a computer program run through our comments and generate an HTML page with all our documentation. Javadoc comments are usually written like this for Classes (from <a href="http://en.wikipedia.org/wiki/Javadoc">Wikipedia</a>)
``java
/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       2010-03-31          (the version of the package this class was first added to)
 */
public class Test {
    // class body
}
```
Note the double asterisk (`**`) at the beginning of the comment. This is a signal to the program that this comment should be taken as documentation. I've documented one of my classes so far, the Primes class. Take a look there for examples on how to document a method. The HTML documentation is located in the `doc/` folder.

With regards to documenting code in your methods apart from the API documentation, ideally, your code should be self-explanatory, and not require comments. A good rule of thumb is code should tell you the *how*, comments should tell you the *why*. A person reading your code should be able to tell what it does without any comments. That means using meaningful variable and method names. An example of good comments to have would be showing how you got from a formula, say the Pythagorean Theorem, into the form that your program uses.
