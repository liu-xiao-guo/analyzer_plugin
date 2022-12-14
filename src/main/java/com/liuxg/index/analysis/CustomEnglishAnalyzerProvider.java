package com.liuxg.index.analysis;

import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.elasticsearch.index.analysis.Analysis;

public class CustomEnglishAnalyzerProvider extends AbstractIndexAnalyzerProvider<EnglishAnalyzer> {
    public static String NAME = "custom_english";

    private final EnglishAnalyzer analyzer;

    public CustomEnglishAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings,
                                         boolean ignoreCase) {
        super(name, settings);

        analyzer = new EnglishAnalyzer(
                Analysis.parseStopWords(env, settings, null, ignoreCase),
                Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET));
    }

    public static CustomEnglishAnalyzerProvider getCustomEnglishAnalyzerProvider(IndexSettings indexSettings,
                                                                                 Environment env, String name,
                                                                                 Settings settings) {
        return new CustomEnglishAnalyzerProvider(indexSettings, env, name, settings, true);
    }

    @Override
    public EnglishAnalyzer get() {
        return this.analyzer;
    }
}