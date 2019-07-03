# Git
Git is a version-control system for tracking changes.  
The notes are based on [git tutorial](https://git-scm.com/docs/gittutorial), [git cheet sheet](https://education.github.com/git-cheat-sheet-education.pdf) and [Xuefeng Liao's Git Tutorial](https://www.liaoxuefeng.com/wiki/896043488029600).  
Using _git help_ to see the git document.

**Contents**
* [Initialization](#initialization)
* [Making changes](#making-changes)
* [Merging branches](#merging-branches)
* [Saving fragments](#saving-fragments)
* [Synchronizing changes](#synchronizing-changes)

## Initialization
* Create a new local repository with the specified name
```
$ mkdir [project-name]
$ cd [project-name]
$ git init
// or in one step
$ git init [project-name]
```
* Download a project and its entire version history
```
$ git clone [url]
```

## Making changes
1. Stage
* Snapshot the file in preparation for versioning
```
$ git add [file]
```
* Unstage the file, but preserve its contents
```
$ git reset [file]
```
* Discard changes that **not yet staged** in working directory
```
$ git checkout -- [file]
```
* Delete the file from the working directory and stage the deletion
```
$ git rm [file]
```
* Remove the file from version control but preserves the file locally
```
$ git rm --cached [file]
```
* Change the file name and prepare it for commit
```
$ git mv [file-original] [file-renamed]
```

* Show file differences **not yet staged**
```
$ git diff
```
* Show file differences **between staging and the last file version**
```
$ git diff --staged
```
* List all new or modified files to be commited
```
$ git status
```
* List version history for the current branch
```
$ git log
// Single one line
$ git log --all --decorate --oneline --graph
```

2. Commit
* Record file snapshots permanently in version history
```
$ git commit -m "[descriptive-message]"
```
* Instead of running _git add_ beforehand, the following command will automatically commit all modified files in one step (not recommanded)
```
$ git commit -a
```
* Undo all commits after a specific commit, preserving changes locally
```
$ git reset [commit_id]
```
* Discard all history and changes back to the specified commit
```
$ git reset --hard [commit_id]
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

## Saving fragments
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
* Add a git URL as an alias
```
$ git remote add [alias] [url]
```
* Fetch down all the branches from that Git remote
```
$ git fetch [alias]
```
* Fetch and merge any commits from the tracking remote branch
```
$ git pull
```
* Uploads all local branch commits to remote
```
$ git push [alias] [branch]
```
