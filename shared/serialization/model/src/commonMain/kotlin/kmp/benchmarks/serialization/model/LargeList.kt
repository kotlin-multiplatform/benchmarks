package kmp.benchmarks.serialization.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPush(
    val id: String,
    val type: String,
    val actor: Actor,
    val repo: Repo.Simple,
    val payload: Payload,
    val public: Boolean,
    @SerialName("created_at") val createdAt: String,
    val org: Org? = null
) {
    @Serializable
    data class Actor(
        val id: Int,
        val login: String,
        @SerialName("gravatar_id") val gravatarId: String,
        val url: String,
        @SerialName("avatar_url") val avatarUrl: String
    )

    @Serializable
    data class Payload(
        @SerialName("push_id") val pushId: Int? = null,
        val size: Int? = null,
        @SerialName("distinct_size") val distinctSize: Int? = null,
        val ref: String? = null,
        val head: String? = null,
        val before: String? = null,
        val commits: List<Commit>? = null,
        @SerialName("ref_type") val refType: String? = null,
        @SerialName("master_branch") val masterBranch: String? = null,
        val description: String? = null,
        @SerialName("pusher_type") val pusherType: String? = null,
        val action: String? = null,
        val release: Release? = null,
        val number: Int? = null,
        @SerialName("pull_request") val pullRequest: PullRequest.Full? = null,
        val issue: Issue? = null,
        val public: Boolean? = null,
        @SerialName("created_at") val createdAt: String? = null,
        val forkee: Repo.Full? = null,
        val pages: List<Page>? = null,
        val comment: Comment? = null,
        val member: User? = null
    )

    @Serializable
    data class Commit(
        val sha: String,
        val author: Author,
        val message: String,
        val distinct: Boolean,
        val url: String
    ) {
        @Serializable
        data class Author(
            val email: String,
            val name: String
        )
    }

    @Serializable
    data class Release(
        val url: String,
        @SerialName("assets_url") val assetsUrl: String,
        @SerialName("upload_url") val uploadUrl: String,
        @SerialName("html_url") val htmlUrl: String,
        val id: Int,
        @SerialName("tag_name") val tagName: String,
        @SerialName("target_commitish") val targetCommitish: String,
        val name: String? = null,
        val draft: Boolean,
        val author: User,
        val prerelease: Boolean,
        @SerialName("created_at") val createdAt: String,
        @SerialName("published_at") val publishedAt: String,
        val assets: List<Asset>,
        @SerialName("tarball_url") val tarballUrl: String,
        @SerialName("zipball_url") val zipballUrl: String,
        val body: String? = null
    ) {
        @Serializable
        data class Asset(
            val url: String,
            val id: Int,
            val name: String,
            val label: String? = null,
            val uploader: User,
            @SerialName("content_type") val contentType: String,
            val state: String,
            val size: Int,
            @SerialName("download_count") val downloadCount: Int,
            @SerialName("created_at") val createdAt: String,
            @SerialName("updated_at") val updatedAt: String,
            @SerialName("browser_download_url") val browserDownloadUrl: String
        )
    }

    @Serializable
    data class Issue(
        val url: String,
        @SerialName("labels_url") val labelsUrl: String,
        @SerialName("comments_url") val commentsUrl: String,
        @SerialName("events_url") val eventsUrl: String,
        @SerialName("html_url") val htmlUrl: String,
        val id: Int,
        val number: Int,
        val title: String,
        val user: User,
        val labels: List<Label>,
        val state: String,
        val locked: Boolean,
        val assignee: User? = null,
        val milestone: Milestone? = null,
        val comments: Int,
        @SerialName("created_at") val createdAt: String,
        @SerialName("updated_at") val updatedAt: String,
        @SerialName("closed_at") val closedAt: String? = null,
        val body: String? = null,
        @SerialName("pull_request") val pullRequest: PullRequest.Simple? = null
    )

    @Serializable
    data class Org(
        val id: Int,
        val login: String,
        @SerialName("gravatar_id") val gravatarId: String,
        val url: String,
        @SerialName("avatar_url") val avatarUrl: String
    )

    @Serializable
    data class User(
        val login: String,
        val id: Int,
        @SerialName("avatar_url") val avatarUrl: String,
        @SerialName("gravatar_id") val gravatarId: String,
        val url: String,
        @SerialName("html_url") val htmlUrl: String,
        @SerialName("followers_url") val followersUrl: String,
        @SerialName("following_url") val followingUrl: String,
        @SerialName("gists_url") val gistsUrl: String,
        @SerialName("starred_url") val starredUrl: String,
        @SerialName("subscriptions_url") val subscriptionsUrl: String,
        @SerialName("organizations_url") val organizationsUrl: String,
        @SerialName("repos_url") val reposUrl: String,
        @SerialName("events_url") val eventsUrl: String,
        @SerialName("received_events_url") val receivedEventsUrl: String,
        val type: String,
        @SerialName("site_admin") val siteAdmin: Boolean
    )

    sealed interface Repo {
        @Serializable
        data class Simple(
            val id: Int,
            val name: String,
            val url: String
        )

        @Serializable
        data class Full(
            val id: Int,
            val name: String,
            @SerialName("full_name") val fullName: String? = null,
            val owner: User,
            val private: Boolean,
            @SerialName("html_url") val htmlUrl: String,
            val description: String? = null,
            val fork: Boolean,
            val url: String,
            @SerialName("forks_url") val forksUrl: String,
            @SerialName("keys_url") val keysUrl: String,
            @SerialName("collaborators_url") val collaboratorsUrl: String,
            @SerialName("teams_url") val teamsUrl: String,
            @SerialName("hooks_url") val hooksUrl: String,
            @SerialName("issue_events_url") val issueEventsUrl: String,
            @SerialName("events_url") val eventsUrl: String,
            @SerialName("assignees_url") val assigneesUrl: String,
            @SerialName("branches_url") val branchesUrl: String,
            @SerialName("tags_url") val tagsUrl: String,
            @SerialName("blobs_url") val blobsUrl: String,
            @SerialName("git_tags_url") val gitTagsUrl: String,
            @SerialName("git_refs_url") val gitRefsUrl: String,
            @SerialName("trees_url") val treesUrl: String,
            @SerialName("statuses_url") val statusesUrl: String,
            @SerialName("languages_url") val languagesUrl: String,
            @SerialName("stargazers_url") val stargazersUrl: String,
            @SerialName("contributors_url") val contributorsUrl: String,
            @SerialName("subscribers_url") val subscribersUrl: String,
            @SerialName("subscription_url") val subscriptionUrl: String,
            @SerialName("commits_url") val commitsUrl: String,
            @SerialName("git_commits_url") val gitCommitsUrl: String,
            @SerialName("comments_url") val commentsUrl: String,
            @SerialName("issue_comment_url") val issueCommentUrl: String,
            @SerialName("contents_url") val contentsUrl: String,
            @SerialName("compare_url") val compareUrl: String,
            @SerialName("merges_url") val mergesUrl: String,
            @SerialName("archive_url") val archiveUrl: String,
            @SerialName("downloads_url") val downloadsUrl: String,
            @SerialName("issues_url") val issuesUrl: String,
            @SerialName("pulls_url") val pullsUrl: String,
            @SerialName("milestones_url") val milestonesUrl: String,
            @SerialName("notifications_url") val notificationsUrl: String,
            @SerialName("labels_url") val labelsUrl: String,
            @SerialName("releases_url") val releasesUrl: String,
            @SerialName("created_at") val createdAt: String,
            @SerialName("updated_at") val updatedAt: String,
            @SerialName("pushed_at") val pushedAt: String,
            @SerialName("git_url") val gitUrl: String,
            @SerialName("ssh_url") val sshUrl: String,
            @SerialName("clone_url") val cloneUrl: String,
            @SerialName("svn_url") val svnUrl: String,
            val homepage: String? = null,
            val size: Int,
            @SerialName("stargazers_count") val stargazersCount: Int,
            @SerialName("watchers_count") val watchersCount: Int,
            val language: String? = null,
            @SerialName("has_issues") val hasIssues: Boolean,
            @SerialName("has_downloads") val hasDownloads: Boolean,
            @SerialName("has_wiki") val hasWiki: Boolean,
            @SerialName("has_pages") val hasPages: Boolean,
            @SerialName("forks_count") val forksCount: Int,
            @SerialName("mirror_url") val mirrorUrl: String? = null,
            @SerialName("open_issues_count") val openIssuesCount: Int,
            val forks: Int,
            @SerialName("open_issues") val openIssues: Int,
            val watchers: Int,
            @SerialName("default_branch") val defaultBranch: String,
            val public: Boolean? = null
        )
    }

    sealed interface PullRequest {
        @Serializable
        data class Simple(
            val url: String,
            @SerialName("html_url") val htmlUrl: String,
            @SerialName("diff_url") val diffUrl: String,
            @SerialName("patch_url") val patchUrl: String
        )

        @Serializable
        data class Full(
            val url: String,
            val id: Int,
            @SerialName("html_url") val htmlUrl: String,
            @SerialName("diff_url") val diffUrl: String,
            @SerialName("patch_url") val patchUrl: String,
            @SerialName("issue_url") val issueUrl: String,
            val number: Int,
            val state: String,
            val locked: Boolean,
            val title: String,
            val user: User,
            val body: String? = null,
            @SerialName("created_at") val createdAt: String,
            @SerialName("updated_at") val updatedAt: String,
            @SerialName("closed_at") val closedAt: String? = null,
            @SerialName("merged_at") val mergedAt: String? = null,
            @SerialName("merge_commit_sha") val mergeCommitSha: String? = null,
            val assignee: User? = null,
            val milestone: Milestone? = null,
            @SerialName("commits_url") val commitsUrl: String,
            @SerialName("review_comments_url") val reviewCommentsUrl: String,
            @SerialName("review_comment_url") val reviewCommentUrl: String,
            @SerialName("comments_url") val commentsUrl: String,
            @SerialName("statuses_url") val statusesUrl: String,
            val head: Ref,
            val base: Ref,
            @SerialName("_links") val links: Links,
            val merged: Boolean? = null,
            val mergeable: Boolean? = null,
            @SerialName("mergeable_state") val mergeableState: String? = null,
            @SerialName("merged_by") val mergedBy: User? = null,
            val comments: Int? = null,
            @SerialName("review_comments") val reviewComments: Int? = null,
            val commits: Int? = null,
            val additions: Int? = null,
            val deletions: Int? = null,
            @SerialName("changed_files") val changedFiles: Int? = null,
            val public: Boolean? = null
        ) {
            @Serializable
            data class Ref(
                val label: String,
                val ref: String,
                val sha: String,
                val user: User,
                val repo: Repo.Full? = null
            )
        }
    }

    @Serializable
    data class Links(
        val self: Link,
        val html: Link,
        @SerialName("pull_request") val pullRequest: Link? = null,
        val issue: Link? = null,
        val comments: Link? = null,
        @SerialName("review_comments") val reviewComments: Link? = null,
        @SerialName("review_comment") val reviewComment: Link? = null,
        val commits: Link? = null,
        val statuses: Link? = null
    ) {
        @Serializable
        data class Link(
            val href: String
        )
    }

    @Serializable
    data class Label(
        val url: String,
        val name: String,
        val color: String
    )

    @Serializable
    data class Page(
        @SerialName("page_name") val pageName: String,
        val title: String,
        val summary: String? = null,
        val action: String,
        val sha: String,
        @SerialName("html_url") val htmlUrl: String
    )

    @Serializable
    data class Comment(
        val url: String,
        @SerialName("html_url") val htmlUrl: String,
        @SerialName("pull_request_url") val pullRequestUrl: String? = null,
        @SerialName("_links") val links: Links? = null,
        @SerialName("issue_url") val issueUrl: String? = null,
        val id: Int,
        @SerialName("diff_hunk") val diffHunk: String? = null,
        val path: String? = null,
        val position: Int? = null,
        val line: Int? = null,
        @SerialName("original_position") val originalPosition: Int? = null,
        @SerialName("commit_id") val commitId: String? = null,
        @SerialName("original_commit_id") val originalCommitId: String? = null,
        val user: User,
        @SerialName("created_at") val createdAt: String,
        @SerialName("updated_at") val updatedAt: String,
        val body: String
    )

    @Serializable
    data class Milestone(
        val url: String,
        @SerialName("labels_url") val labelsUrl: String,
        val id: Int,
        val number: Int,
        val title: String,
        val description: String? = null,
        val creator: User,
        @SerialName("open_issues") val openIssues: Int,
        @SerialName("closed_issues") val closedIssues: Int,
        val state: String,
        @SerialName("created_at") val createdAt: String,
        @SerialName("updated_at") val updatedAt: String,
        @SerialName("due_on") val dueOn: String? = null,
        @SerialName("closed_at") val closedAt: String? = null
    )
}