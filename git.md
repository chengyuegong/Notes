# Git
Git is a version-control system for tracking changes.  
The notes are based on [git tutorial](https://git-scm.com/docs/gittutorial) and [git cheet sheet](https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf)  
Using _git help_ to see the git document.

## Initialization
1. Create a directory
2. Go into the directory
3. Initialize the working directory
```
$ mkdir myproject
$ cd myproject
$ git init
```

## Making changes
1. Staging: Add the modified contents to the index
```
$ git add [file]
```
* See difference
```
$ git diff
```
* See a brief summary
```
$ git status
```
* See history
```
$ git log
```
* Unstage the file
```
$ git reset [file]
```
2. Commit: commit changes (-m indicates the commit message)
```
$ git commit -m "[message]"
```
* Instead of running _git add_ beforehand, the following command will automatically commit all modified files in one step
```
$ git commit -a
```
* Undo all commits after _commit_
```
$ git reset [commit]
```

## Merging branches
1. Create a branch
```
$ git branch [branch-name]
```
* See existing branches
```
$ git branch
```
2. Switch to the new branch, edit files and commit
```
$ git checkout [branch-name]
(edit files)
$ git commit -a
```
3. Switch back to the master branch, and merge changes made in mybranch into master (If changes conflict, using _git diff_ to see difference and resolve)
```
$ git checkout master
$ git merge [branch]
```
4. Delete the branch (-D for force delete)
```
$ git branch -d [branch-name]
```

## Saving fragements
1. Store all modified trakced files
```
$ git stash
```
* See stashed fiels
```
$ git stash list
```
2. Restore the most recently stashed files
```
$ git stash pop
```
* Delete the most recently stashed changeset
```
$ git stash drop
```

## Synchronizing changes
* Download a project from a remote repository
```
$ git clone [url]
```
* Download history and incorporates changes
```
$ git pull
```
* Upload local commits to a remote repository
```
$ git push [branch]
```
