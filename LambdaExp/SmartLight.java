class SmartLight:
    def __init__(self, name):
        self.name = name
        self.behaviors = {}

    def add_behavior(self, trigger, action):
        self.behaviors[trigger] = action

    def trigger(self, trigger):
        if trigger in self.behaviors:
            print(f"Triggering '{trigger}' behavior for {self.name}:")
            self.behaviors[trigger]()
        else:
            print(f"No behavior defined for trigger '{trigger}' on {self.name}.")


living_room_light = SmartLight("Living Room Light")

living_room_light.add_behavior("motion_detected",
    lambda: print("💡 Turning ON softly — someone entered the room.")
)

living_room_light.add_behavior("no_motion",
    lambda: print("💡 Dimming lights — room seems empty.")
)

living_room_light.add_behavior("voice_command_evening",
    lambda: print("🌆 Setting warm orange glow for evening ambiance.")
)

living_room_light.add_behavior("voice_command_movie",
    lambda: print("🎬 Dimming lights for movie mode.")
)

living_room_light.trigger("motion_detected")
living_room_light.trigger("voice_command_movie")
living_room_light.trigger("no_motion")
