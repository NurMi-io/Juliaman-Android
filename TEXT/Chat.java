// Import this Bubble Message.
<activity
  android:name=".bubbles.BubbleActivity"
  android:theme="@style/AppTheme.NoActionBar"
  android:label="@string/title_activity_bubble"
  android:allowEmbedded="true"
  android:resizeableActivity="true"
/>
  // Create a bubble intent.
Intent target = new Intent(mContext, BubbleActivity.class);
PendingIntent bubbleIntent =
    PendingIntent.getActivity(mContext, 0, target, 0 /* flags */);

private val CATEGORY_TEXT_SHARE_TARGET =
    "com.example.category.IMG_SHARE_TARGET"

Person chatPartner = new Person.Builder()
        .setName("Chat partner")
        .setImportant(true)
        .build();

// Create a sharing shortcut.
private String shortcutId = generateShortcutId();
ShortcutInfo shortcut =
   new ShortcutInfo.Builder(mContext, shortcutId)
       .setCategories(Collections.singleton(CATEGORY_TEXT_SHARE_TARGET))
       .setIntent(Intent(Intent.ACTION_DEFAULT))
       .setLongLived(true)
       .setShortLabel(chatPartner.getName())
       .build();

// Create a bubble metadata.
Notification.BubbleMetadata bubbleData =
    new Notification.BubbleMetadata.Builder(bubbleIntent,
            Icon.createWithResource(context, R.drawable.icon))
        .setDesiredHeight(600)
        .build();

// Create a notification, referencing the sharing shortcut.
Notification.Builder builder =
    new Notification.Builder(mContext, CHANNEL_ID)
        .setContentIntent(contentIntent)
        .setSmallIcon(smallIcon)
        .setBubbleMetadata(bubbleData)
        .setShortcutId(shortcutId)
        .addPerson(chatPartner); 
// Notification Bubble Add
Notification.BubbleMetadata bubbleData =
    new Notification.BubbleMetadata.Builder()
        .setDesiredHeight(600)
        .setIntent(bubbleIntent)
        .setAutoExpandBubble(true)
        .setSuppressNotification(true)
        .build();
