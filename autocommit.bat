cd %~1
"%~2git.exe" add .
"%~2git.exe" commit -a --allow-empty -m"Automated Modjam Coomit: %TIME%"

pause