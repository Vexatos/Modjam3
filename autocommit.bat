cd %~1
"%~2git.exe" add .
"%~2git.exe" commit -a -m"message %TIME%"

pause