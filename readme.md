# Pet Project to Practice in Spring and Other Modern Technologies

## MVP Features

### For Unregistered Users
- **Registration**
    - One-Time Password (OTP)
        - Valid for 10 minutes
        - Maximum 2 attempts
        - OTP must be deleted or invalidated after registration
- **Person to Person Registration**
    - Table tracking who registers whom
    - Timestamp (optional)
- **Help and Info Commands**

### For Registered Users
- **Create Registration OTP**
- **Register for Events**

### Create Events
- Notify everyone interested
- Create interests in events

## Future Enhancements

### User Roles
- **Default User**
    - View events
    - Subscribe to interests
    - Create interests
- **Organizer**
    - All Default permissions, plus:
        - Create events
        - View user interests
- **Admin**
    - All Organizer permissions, plus:
        - Ban users
- **Banned User**
    - Restricted from using the bot
    - Cannot be invited again

### Language Selection
- English localization
- Possible Russian localization
