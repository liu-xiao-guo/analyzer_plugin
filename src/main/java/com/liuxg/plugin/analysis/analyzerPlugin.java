package com.liuxg.plugin.analysis;

import org.elasticsearch.plugins.Plugin;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import  com.liuxg.index.analysis.CustomEnglishAnalyzerProvider;
import org.elasticsearch.indices.analysis.AnalysisModule;

import java.util.HashMap;
import java.util.Map;

public class analyzerPlugin extends Plugin implements org.elasticsearch.plugins.AnalysisPlugin {
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> analyzers = new HashMap<>();
        analyzers.put(CustomEnglishAnalyzerProvider.NAME, CustomEnglishAnalyzerProvider::getCustomEnglishAnalyzerProvider);
        return analyzers;
    }
}