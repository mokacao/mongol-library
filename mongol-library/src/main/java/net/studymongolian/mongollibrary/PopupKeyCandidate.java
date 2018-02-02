package net.studymongolian.mongollibrary;

import android.text.TextUtils;


/**
 * these are the choices for a popup key
 */
public class PopupKeyCandidate {

    private String unicode;
    private String display;
    private String composing;
    // The composing String can be set if a unicode character would be temperarily rendered incorrectly.
    // For example, a mongolian medial would be rendered as a final until another character is typed.
    // Adding the composing span will let it be displayed as a medial until the next char is typed.

    /**
     * Convenience constructor for PopupCandidates(String unicode)
     *
     * @param unicode the unicode values for the popup items
     */
    public PopupKeyCandidate(char unicode) {
        this(String.valueOf(unicode));
    }

    /**
     * Convenience constructor for PopupCandidates(String unicode, String display, String composing)
     */
    public PopupKeyCandidate(String unicode) {
        this(unicode, null, null);
    }

    /**
     * Convenience constructor for PopupCandidates(String unicode, String display, String composing)
     */
    public PopupKeyCandidate(String unicode, String display) {
        this(unicode, display, null);
    }

    /**
     * @param unicode the unicode value for a popup item
     * @param display the value to display if different than the unicode value
     * @param composing the value to display for a temporary composing span
     */
    public PopupKeyCandidate(String unicode, String display, String composing) {
        this.unicode = unicode;
        this.display = display;
        this.composing = composing;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(unicode);
    }

    public String getUnicode() {
        return unicode;
    }

    public String getDisplay() {
        return display;
    }

    public String getComposing() {
        return composing;
    }

    public static PopupKeyCandidate[] createArray(char unicode) {
        return new PopupKeyCandidate[] { new PopupKeyCandidate(unicode)};
    }

    public static PopupKeyCandidate[] createArray(String unicode) {
        return new PopupKeyCandidate[] { new PopupKeyCandidate(unicode)};
    }

    public static PopupKeyCandidate[] createArray(String[] unicodeCandidates) {
        PopupKeyCandidate[] candidates = new PopupKeyCandidate[unicodeCandidates.length];
        for (int i = 0; i < unicodeCandidates.length; i++) {
            candidates[i] = new PopupKeyCandidate(unicodeCandidates[i]);
        }
        return candidates;
    }

}