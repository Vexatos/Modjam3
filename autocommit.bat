cd %~1
"%~2git.exe" add .
"%~2git.exe" commit -a --allow-empty -m"message %TIME%"

pause