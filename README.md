# Modfirm

Keep your players updated to the latest mods for your server automatically! 

**What I'm Developing**
- Modfirm.jar: Separate java instance application that handles the version checking,  mods verification, and Debugging.
- Modfirm-versions.jar: Fabric/Forge mod that contacts the server for its version and doesn't let the player join if there is any mismatch.
- Modfirm-server.jar: Fabric/Forge mod that requires the client to have modfirm-versions.jar installed and responds to version requests.
- Modfirm-helper.jar: Separate application that may help you obtain your mods list and each mod's SHA256 hash.

**Other things you need**
1. Google Sheets API Key: For public access to your...
2. Google Sheets: which stores and handles versions, hashes and other information.

## Note 

These mods are very much in development. I try to make sure everything is well documented in the code for the sake of future documentation. I will publish my own documentation on how to build and install this for servers and clients when I am done.

I will prioritize getting everything set-up for my use case first before I attempt to make this mod more "open" to other users. This means that I may hard-code values which should be more accessible (like to be put in a .json file instead).

Side Note: This program/mod does not aim to moderate the mods a user has upon joining a server. You can add that functionality yourself but that is not the goal of this project.

**Beta Image of Client Updater**<br/>
![image](https://i.imgur.com/JSAY5Ab.png)

**Progress**
- Modfirm.jar: 60%
- Modfirm-versions.jar: 10% (no commit to here yet)
- Modfirm-server.jar: 10% (no commit to here yet)
- Modfirm-helper.jer: 85%

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[GNU GPL 3.0](https://choosealicense.com/licenses/gpl-3.0/)<br/>
Basically everything is open source except for the times it isn't.
If you plan to modify this mod and re-release it, you must release it with the same license, or something more "open".
