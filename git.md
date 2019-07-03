# Git
Git is a version-control system for tracking changes.  
The notes are based on [git tutorial](https://git-scm.com/docs/gittutorial), [git cheet sheet](https://education.github.com/git-cheat-sheet-education.pdf), and [Xuefeng Liao's Git Tutorial](https://www.liaoxuefeng.com/wiki/896043488029600).  
Using _git help_ to see the git document.

**Contents**
* [Initialization](#initialization)
* [Making changes](#making-changes)
* [Merging branches](#merging-branches)
* [Rewriting history](#rewriting-history)
* [Tag](#tag)
* [Saving fragments](#saving-fragments)
* [Synchronizing changes](#synchronizing-changes)

## Initialization
* Initialize an existing directory as a Git repository
```
$ git init
```
* Create a new local repository with the specified name
```
$ git init [project]
```
* Retrieve an entire repository from a hosted location via URL
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
$ git reset [commit-id]
```
* Discard all history and changes back to the specified commit
```
$ git reset --hard [commit-id]
```


## Merging branches
* List branches (a * will appear next to the currently active branch)
```
$ git branch
```
* Create a new branch at the current commit
```
$ git branch [branch]
```
* Switch to another branch and check it out into your working directory
```
$ git checkout [branch]
```
* Create a new branch and switch to it in one step
```
$ git checkout -b [branch]
```
* Merge the specified branch’s history into the current one
```
$ git merge [branch]
```
* Delete the branch (-D for force delete)
```
$ git branch -d [branch]
```
* Set up branch's tracking information so upstream is considered branch's upstream branch  
```
$ git branch -u [upstream] [branch]
// or
$ git branch --set-upstream-to=[upstream] [branch]
```


## Rewriting history
[Reference](https://www.atlassian.com/git/tutorials/rewriting-history)
* Change the most recent commit message
```
$ git commit --amend -m "[descriptive-message]"
```
* Change committed files without changing the commit message
```
$ git commit --amend --no-edit
```
* Apply any commits of current branch ahead of specified branch
```
$ git rebase [branch]
```
* Rebase interactively with the opportunity to alter individual commits in the process
```
$ git rebase -i [branch]
```
* Display the reference logs for the local repository
```
$ git reflog
```
* Show the reference logs with relative date information
```
$ git reflog --relative-date
```

## Tag
* List all tags
```
$ git tag
```
* Create a tag
```
$ git tag [tag]
```
* Create a tag on a specific commit
```
$ git tag [tag] [commit-id]
```
* Create a tag with a descriptive message
```
$ git tag -a [tag] -m "[descriptive-message]"
```
* Delete a tag
```
$ git tag -d [tag]
```
* Push a tag to the remote branch
```
$ git push [alias] [tag]
```
* push all tags to the remote branch
```
$ git push [alias] --tags
```
* Delete a tag from the remote branch
```
$ git push [alias] :refs/tags/[tag]
```


## Saving fragments
* Save modified and staged changes
```
$ git stash
```
* List all stashed changesets
```
$ git stash list
```
* Restore the most recently stashed files
```
$ git stash apply
```
* Discard the most recently stashed changeset
```
$ git stash drop
```
* Restore and discard the most recently stashed changeset
```
$ git stash pop
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
