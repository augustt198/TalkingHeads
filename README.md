TalkingHeads
============

Bukkit plugin for adding a message to your player, that is displayed when someone right clicks your player head, or does
`/getmessage [username]`. You can set your message with `/setmessage [message]`. Messages are saved using MongoDB.

#Building

Use `mvn clean install` and move the `target/talkingheads-0.1.jar` file to `plugins/`

Dependencies: `mongodb-driver`

#Configuration

Configuration of the `config.yml` file is the same as in `augustt198/MongoRegister`, except `emailfield` 
is now `messagefield` (the field for storing the player's message).

